/*
 *  @ (#) OrderDetail.java      1.0 26/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise02;

import java.text.DecimalFormat;

/**
 * Lớp OrderDetail phụ thuộc vào lớp Product (quan hệ Dependency)
 * Lớp OrderDetail là một phần của lớp Order (quan hệ Composition)
 * @author: tungpt
 * @version: 1.0
 * @since: August 26, 2023
 */
public class OrderDetail {
    private int quantity;
    private Product product;

    public OrderDetail(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }

    public double calcTotalPrice(){
        return getQuantity() * this.product.getPrice();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        return String.format("%s | %15d | %20s",
                this.product, getQuantity(), decimalFormat.format(calcTotalPrice())
        );
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            quantity = 0;
        }
        this.quantity = quantity;
    }
}
