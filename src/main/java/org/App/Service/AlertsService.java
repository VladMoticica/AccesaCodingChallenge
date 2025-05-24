package org.App.Service;

import org.App.Models.Alerts;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlertsService {

    private final Map<String, List<Alerts>> alertsByProductId = new HashMap<>();

    public void addAlert(String productId, float targetPrice) {
        Alerts alert = new Alerts(productId, targetPrice);
        alertsByProductId.computeIfAbsent(productId, k -> new ArrayList<>()).add(alert);
    }

    public List<Alerts> getAlertsForProduct(String productId) {
        return alertsByProductId.getOrDefault(productId, new ArrayList<>());
    }

    public Map<String, List<Alerts>> getAllAlerts() {
        return alertsByProductId;
    }

    public boolean deleteAlert(String productId, Float targetPrice) {
        List<Alerts> alerts = alertsByProductId.get(productId);
        if (alerts == null || alerts.isEmpty()) return false;

        boolean removed;
        if (targetPrice == null) {
            alertsByProductId.remove(productId);
            removed = true;
        } else {
            removed = alerts.removeIf(a -> a.getTargetPrice() == targetPrice);
            if (alerts.isEmpty()) {
                alertsByProductId.remove(productId);
            }
        }
        return removed;
    }
}