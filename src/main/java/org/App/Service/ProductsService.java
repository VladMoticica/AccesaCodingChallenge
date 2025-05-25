package org.App.Service;

import org.App.Models.Alerts;
import org.App.Models.Products;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductsService {

    private final Map<String, List<Products>> productsByStore = new HashMap<>();

    public void addProduct(String store, Products product) {
        productsByStore.computeIfAbsent(store, k -> new ArrayList<>()).add(product);
    }

    public List<Products> getAllProducts() {
        List<Products> all = new ArrayList<>();
        for (List<Products> storeProducts : productsByStore.values()) {
            all.addAll(storeProducts);
        }
        return all;
    }

    public List<Products> getProductsByStore(String store) {
        return productsByStore.getOrDefault(store, new ArrayList<>());
    }

    public Set<String> getAllCategories() {
        Set<String> categories = new HashSet<>();
        for (Products product : getAllProducts()) {
            categories.add(product.getP_product_category());
        }
        return categories;
    }

    public List<Products> getProductsByCategory(String category) {
        return getAllProducts().stream()
                .filter(p -> p.getP_product_category().equalsIgnoreCase(category))
                .toList();
    }

    public List<Products> findBestBuy() {
        return getAllProducts().stream()
                .filter(p -> p.getPricePerUnit() != null)
                .sorted(Comparator.comparing(Products::getPricePerUnit))
                .limit(50)
                .toList();
    }

    public List<Products> getTriggeredAlerts(List<Alerts> alerts) {
        List<Products> allProducts = getAllProducts();

        List<Products> triggered = new ArrayList<>();

        for (Alerts alert : alerts) {
            allProducts.stream()
                    .filter(p -> p.getP_product_id().equals(alert.getProductId()))
                    .filter(p -> p.getP_price() != null && p.getP_price() <= alert.getTargetPrice())
                    .findFirst()
                    .ifPresent(triggered::add);
        }

        return triggered;
    }

    public List<Products> findCheapestPerProduct(List<String> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            return Collections.emptyList();
        }

        List<Products> allProducts = getAllProducts();

        return productIds.stream()
                .distinct()  // Remove duplicates if same product is selected multiple times
                .map(pid -> allProducts.stream()
                        .filter(p -> pid.equals(p.getP_product_id()))
                        .min(Comparator.comparing(Products::getP_price))
                        .orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }

    public float calculateTotal(List<Products> cheapestProducts) {
        if (cheapestProducts == null || cheapestProducts.isEmpty()) {
            return 0.0f;
        }

        return (float) cheapestProducts.stream()
                .mapToDouble(Products::getP_price)
                .sum();
    }
}