package org.App.Controllers;

import org.App.Basic.Products;
import org.App.Service.ProductsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsService serviceP;

    public ProductsController(ProductsService service) {
        this.serviceP = service;
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return serviceP.getAllProducts();
    }

    @GetMapping("/store/{store}")
    public List<Products> getByStore(@PathVariable String store) {
                return serviceP.getProductsByStore(store);
    }

    @GetMapping("/categories")
    public Set<String> getAllCategories() {
        return serviceP.getAllCategories();
    }

    @GetMapping("/category/{category}")
    public List<Products> getByCategory(@PathVariable String category) {
        return serviceP.getProductsByCategory(category);
    }

    @GetMapping("/best")
    public List<Products> getBestBuy() {
        return serviceP.findBestBuy();
    }
}