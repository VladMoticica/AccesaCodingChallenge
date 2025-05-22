package Basic;

import java.util.Date;

public class Discounts
{
    private String D_product_id;
    private String D_product_name;
    private String D_brand;
    private Float D_package_quantity;
    private String D_package_unit;
    private String D_product_category;
    private java.util.Date D_from_date;
    private java.util.Date D_to_date;
    private int D_percentage_of_discount;

    public String getD_product_id() {
        return D_product_id;
    }

    public void setD_product_id(String d_product_id) {
        D_product_id = d_product_id;
    }

    public String getD_product_name() {
        return D_product_name;
    }

    public void setD_product_name(String d_product_name) {
        D_product_name = d_product_name;
    }

    public String getD_brand() {
        return D_brand;
    }

    public void setD_brand(String d_brand) {
        D_brand = d_brand;
    }

    public Float getD_package_quantity() {
        return D_package_quantity;
    }

    public void setD_package_quantity(Float d_package_quantity) {
        D_package_quantity = d_package_quantity;
    }

    public String getD_package_unit() {
        return D_package_unit;
    }

    public void setD_package_unit(String d_package_unit) {
        D_package_unit = d_package_unit;
    }

    public String getD_product_category() {
        return D_product_category;
    }

    public void setD_product_category(String d_product_category) {
        D_product_category = d_product_category;
    }

    public Date getD_from_date() {
        return D_from_date;
    }

    public void setD_from_date(Date d_from_date) {
        D_from_date = d_from_date;
    }

    public Date getD_to_date() {
        return D_to_date;
    }

    public void setD_to_date(Date d_to_date) {
        D_to_date = d_to_date;
    }

    public int getD_percentage_of_discount() {
        return D_percentage_of_discount;
    }

    public void setD_percentage_of_discount(int d_percentage_of_discount) {
        D_percentage_of_discount = d_percentage_of_discount;
    }
}
