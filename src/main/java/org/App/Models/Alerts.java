package org.App.Models;

public class Alerts {
    private String productId;
    private float targetPrice;

    public Alerts(String productId, float targetPrice) {
        this.productId = productId;
        this.targetPrice = targetPrice;
    }

    public String getProductId() {
        return productId;
    }

    public float getTargetPrice() {
        return targetPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setTargetPrice(float targetPrice) {
        this.targetPrice = targetPrice;
    }
}