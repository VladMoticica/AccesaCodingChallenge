package org.App.Service;

import org.App.Basic.Products;
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
}