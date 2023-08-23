/*
 *  @ (#) Vehicle.java      1.0 23/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise03;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 23, 2023
 */
public class Vehicle {
    // loại xe
    private String brand;
    // dung tích xylanh
    private int capacity;
    // đơn giá
    private double unitPrice;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
