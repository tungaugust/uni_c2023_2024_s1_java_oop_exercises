/*
 *  @ (#) Customer.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise01;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public class Customer extends Person {
    private double saleValue;

    public Customer() {
        super();
        this.saleValue = 0.0;
    }

    public Customer(String id, String name, double saleValue) {
        super(id, name);
        setSaleValue(saleValue);
    }

    public double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    @Override
    public String toString() {
        return String.format("%s %,.2f", super.toString(), saleValue);
    }
}
