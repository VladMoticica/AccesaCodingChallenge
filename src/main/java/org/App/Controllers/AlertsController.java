package org.App.Controllers;

import org.App.Models.Alerts;
import org.App.Models.Products;
import org.App.Service.AlertsService;
import org.App.Service.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertsController {

    private final AlertsService priceAlertService;
    private final ProductsService productService;

    public AlertsController(AlertsService priceAlertService, ProductsService productService) {
        this.priceAlertService = priceAlertService;
        this.productService = productService;
    }

    @GetMapping
    public List<Alerts> getAllAlerts() {
        return priceAlertService.getAllAlerts()
                .values()
                .stream()
                .flatMap(List::stream)
                .toList();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAlert(@RequestParam String productId, @RequestParam float targetPrice) {

        priceAlertService.addAlert(productId, targetPrice);
        return ResponseEntity.ok("Alert added successfully.");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteAlertForm(@RequestParam String productId, @RequestParam(required = false) Float targetPrice) {

        boolean success = priceAlertService.deleteAlert(productId, targetPrice);
        if (success) {
            return ResponseEntity.ok("Alert(s) deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alert not found.");
        }
    }

    @GetMapping("/triggered")
    public List<Products> getTriggeredAlerts() {
        List<Alerts> allAlerts = priceAlertService.getAllAlerts()
                .values()
                .stream()
                .flatMap(List::stream)
                .toList();

        return productService.getTriggeredAlerts(allAlerts);
    }
}