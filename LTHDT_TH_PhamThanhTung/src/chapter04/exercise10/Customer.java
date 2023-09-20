/*
 *  @ (#) Customer.java       1.0 06/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise10;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 06, 2023
 */
public class Customer extends Person{
    private String company;
    private double billPrice;

    public Customer() {
        this(null, null, null,0.0);
    }

    public Customer(String name, String address, String company, double billPrice) {
        super(name, address);
        setCompany(company);
        setBillPrice(billPrice);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if(company == null || company.equals("")){
            company = "No name";
        }
        this.company = company;
    }

    public double getBillPrice() {
        return billPrice;
    }

    public void setBillPrice(double billPrice) {
        if (billPrice < 0) {
            billPrice = 0.0;
        }
        this.billPrice = billPrice;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %,.3f", super.toString(), getCompany(), getBillPrice());
    }

    @Override
    public String evaluate() {
        // Đánh giá nhân viên dựa trên số tiền của hoá đơn
        double billAmount = getBillPrice();
        String evaluation;
        if (!(billAmount < 100000000.0)) {
            evaluation = "Tier 1";
        } else if (!(billAmount < 40000000.0)) {
            evaluation = "Tier 2";
        } else {
            evaluation = "Tier 3";
        }
        return evaluation;
    }
}
