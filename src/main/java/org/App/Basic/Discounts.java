package org.App.Basic;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "d_product_id",
        "d_product_name",
        "d_brand",
        "d_package_quantity",
        "d_package_unit",
        "d_product_category",
        "d_from_date",
        "d_to_date",
        "d_percentage_of_discount"
})

public class Discounts
{
    private String d_product_id;
    private String d_product_name;
    private String d_brand;
    private Float d_package_quantity;
    private String d_package_unit;
    private String d_product_category;
    private LocalDate d_from_date;
    private LocalDate d_to_date;
    private int d_percentage_of_discount;

    public String getD_product_id() {
        return d_product_id;
    }

    public void setD_product_id(String d_product_id) {
        this.d_product_id = d_product_id;
    }

    public String getD_product_name() {
        return d_product_name;
    }

    public void setD_product_name(String d_product_name) {
        this.d_product_name = d_product_name;
    }

    public String getD_brand() {
        return d_brand;
    }

    public void setD_brand(String d_brand) {
        this.d_brand = d_brand;
    }

    public Float getD_package_quantity() {
        return d_package_quantity;
    }

    public void setD_package_quantity(Float d_package_quantity) {
        this.d_package_quantity = d_package_quantity;
    }

    public String getD_package_unit() {
        return d_package_unit;
    }

    public void setD_package_unit(String d_package_unit) {
        this.d_package_unit = d_package_unit;
    }

    public String getD_product_category() {
        return d_product_category;
    }

    public void setD_product_category(String d_product_category) {
        this.d_product_category = d_product_category;
    }

    public LocalDate getD_from_date() {
        return d_from_date;
    }

    public void setD_from_date(LocalDate d_from_date) {
        this.d_from_date = d_from_date;
    }

    public LocalDate getD_to_date() {
        return d_to_date;
    }

    public void setD_to_date(LocalDate d_to_date) {
        this.d_to_date = d_to_date;
    }

    public int getD_percentage_of_discount() {
        return d_percentage_of_discount;
    }

    public void setD_percentage_of_discount(int d_percentage_of_discount) {
        this.d_percentage_of_discount = d_percentage_of_discount;
    }
}
