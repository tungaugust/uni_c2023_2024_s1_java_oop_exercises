/*
 *  @ (#) Savings.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise15;

/**
 * Lớp Savings là lớp thể hiện tài khoản tiết kiệm
 * Đây là tài khoản cho phép tiết kiệm tiền gửi với lãi kép.
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class Savings extends Account {
    private double intRate; // lãi suất năm
    private double intAmount;   // tiền lãi

    public Savings(String accID, double balance, double intRate) {
        super(accID, balance);
        setIntRate(intRate);
        this.intAmount = 0.0;
    }

    private double calculateInterest() {
        double amount = getBalance() * getIntRate() / 12;
        this.intAmount += amount;
        return amount;
    }
    public void addInterestToBalance() {
        deposit(calculateInterest());
    }

    public double getInterestAmount() {
        return intAmount;
    }

    public double getIntRate() {
        return intRate;
    }

    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }
}
