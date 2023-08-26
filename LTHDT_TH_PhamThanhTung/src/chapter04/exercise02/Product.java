/*
 *  @ (#) Product.java      1.0 26/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise02;

import java.text.DecimalFormat;

/**
 * Lớp Product là lớp bị phụ thuộc bởi lớp OrderDetail (quan hệ Dependency)
 * @author: tungpt
 * @version: 1.0
 * @since: August 26, 2023
 */
public class Product {
    private String productID;
    private String description;
    private double price;

    public Product() {
        this.productID = "chưa xác định";
        this.description = "";
        this.price = 0.0;
    }

    public Product(String productID, String description, double price) {
        setProductID(productID);
        setDescription(description);
        setPrice(price);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return String.format("%-10s | %-25s | %15s",
                getProductID(), getDescription(), decimalFormat.format(getPrice())
        );
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        if (productID.equals("")) {
            productID = "chưa xác định";
        }
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            price = 0.0;
        }
        this.price = price;
    }
}
