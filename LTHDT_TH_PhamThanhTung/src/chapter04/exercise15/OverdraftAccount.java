/*
 *  @ (#) OverdraftAccount.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise15;

/**
 * Lớp OverdraftAccount là lớp thể hiện tài khoản thấu chi | TÀI KHOẢN TÍN DỤNG
 * Đây là tài khoản ngân hàng cho phép chi tiêu (rút tiền) vượt quá số dư có trong tài khoản.
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class OverdraftAccount extends Account {
    private double odLimit; // hạn mức thấu chi
    private double overdraft;   // thấu chi
    private double availableBalance;    // số dư khả dụng

    public OverdraftAccount(String accID, double balance, double odLimit) {
        super(accID, balance);
        setOdLimit(odLimit);
        setAvailableBalance(balance + odLimit);
        this.overdraft = 0.0;
    }

    public double getOdLimit() {
        return odLimit;
    }

    private void setOdLimit(double odLimit) {
        this.odLimit = odLimit;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    private void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount < 0 || amount > this.availableBalance) {
            return false;
        }
        double odDiff = this.odLimit - this.overdraft;  // số tiền còn có thể thấu chi
        double balance = this.availableBalance - odDiff;    // số dư thực sự
        setAvailableBalance(this.availableBalance - amount);
        if (amount > balance) {
            // tính lại khoảng thấu chi
            this.overdraft = this.overdraft + (amount + balance);
        }
        return true;
    }

    @Override
    public void deposit(double amount) {
        setAvailableBalance(getAvailableBalance() + amount);
    }
}
