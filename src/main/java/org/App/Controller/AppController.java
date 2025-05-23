package org.App.Controller;

import org.App.Basic.Products;
import org.App.Service.ProductsService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app")
public class AppController {
    private final ProductsService service;

    public AppController(ProductsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Products> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/best-deals")
    public List<Products> getBestDeals() {
        return service.findBestDeals();
    }

    @GetMapping("/store/{store}")
    public List<Products> getByStore(@PathVariable String store) {
        return service.getProductsByStore(store);
    }

    @GetMapping("/search")
    public List<Products> searchByName(@RequestParam String keyword) {
        return service.searchByName(keyword);
    }

    @GetMapping("/categories")
    public Set<String> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/category/{category}")
    public List<Products> getByCategory(@PathVariable String category) {
        return service.getProductsByCategory(category);
    }
}