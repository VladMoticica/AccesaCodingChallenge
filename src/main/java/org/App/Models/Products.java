package org.App.Models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonPropertyOrder({
        "p_product_id",
        "p_product_name",
        "p_product_category",
        "p_brand",
        "p_package_quantity",
        "p_package_unit",
        "p_price",
        "p_currency"
})

public class Products
{
    private String p_product_id;
    private String p_product_name;
    private String p_product_category;
    private String p_brand;
    private Float p_package_quantity;
    private String p_package_unit;
    private Float p_price;
    private String p_currency;

    public String getP_product_id() {
        return p_product_id;
    }

    public void setP_product_id(String p_product_id) {
        this.p_product_id = p_product_id;
    }

    public String getP_product_name() {
        return p_product_name;
    }

    public void setP_product_name(String p_product_name) {
        this.p_product_name = p_product_name;
    }

    public String getP_product_category() {
        return p_product_category;
    }

    public void setP_product_category(String p_product_category) {
        this.p_product_category = p_product_category;
    }

    public String getP_brand() {
        return p_brand;
    }

    public void setP_brand(String p_brand) {
        this.p_brand = p_brand;
    }

    public Float getP_package_quantity() {
        return p_package_quantity;
    }

    public void setP_package_quantity(Float p_package_quantity) {
        this.p_package_quantity = p_package_quantity;
    }

    public String getP_package_unit() {
        return p_package_unit;
    }

    public void setP_package_unit(String p_package_unit) {
        this.p_package_unit = p_package_unit;
    }

    public Float getP_price() {
        return p_price;
    }

    public void setP_price(Float p_price) {
        this.p_price = p_price;
    }

    public String getP_currency() {
        return p_currency;
    }

    public void setP_currency(String p_currency) {
        this.p_currency = p_currency;
    }

    @JsonProperty("p_price_per_unit")
    public Float getPricePerUnit() {
        if (p_price == null || p_package_quantity == null || p_package_unit == null || p_package_quantity <= 0) {
            return null;
        }

        float normalizedQuantity;
        switch (p_package_unit.toLowerCase()) {
            case "kg", "l" -> normalizedQuantity = p_package_quantity * 1000;
            case "g", "ml", "buc" -> normalizedQuantity = p_package_quantity;
            default -> normalizedQuantity = 0;
        }

        if (normalizedQuantity <= 0) return null;
        float rawValue = p_price / normalizedQuantity;

        BigDecimal rounded = new BigDecimal(rawValue).setScale(4, RoundingMode.HALF_UP);
        return rounded.floatValue();
    }
}
