package org.App.Controllers;

import org.App.Models.Products;
import org.App.Service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final ProductsService productsService;

    public BasketController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping("/optimize")
    public Map<String, Object> optimizeBasket(@RequestBody List<String> productIds) {
        if (productIds == null || productIds.isEmpty()) {
            throw new IllegalArgumentException("Product IDs list cannot be empty");
        }

        List<Products> optimized = productsService.findCheapestPerProduct(productIds);
        float total = productsService.calculateTotal(optimized);

        Map<String, Object> result = new HashMap<>();
        result.put("recommendedSplit", optimized);
        result.put("totalCost", total);
        return result;
    }
}