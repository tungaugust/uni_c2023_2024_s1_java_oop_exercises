/*
 *  @ (#) Vehicle.java      1.0 23/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise03;

/**
 * Lớp xe cộ
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
        if (brand.equals("")){
            brand = "Unidentified!";
        }
        this.brand = brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        this.capacity = capacity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (unitPrice < 0) {
            unitPrice = 0.0;
        }
        this.unitPrice = unitPrice;
    }

    public Vehicle() {
        this.brand = "";
        this.capacity = 0;
        this.unitPrice = 0.0;
    }

    public Vehicle(String brand, int capacity, double unitPrice) {
        setBrand(brand);
        setCapacity(capacity);
        setUnitPrice(unitPrice);
    }

    @Override
    public String toString() {
        return String.format("%-20s %15d %20.2f",
                getBrand(), getCapacity(), getUnitPrice()
        );
    }

}
