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
        setAvailableBalance(getBalance() + getOdLimit());
        this.overdraft = 0.0;
    }

    public double getOdLimit() {
        return odLimit;
    }

    private void setOdLimit(double odLimit) {
        if (odLimit < 0) {
            odLimit = 0.0;
        }
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
        if (amount < 0 || amount > getAvailableBalance()) {
            return false;
        }
        double balance = getBalance();
        double available = getAvailableBalance();
        if (amount > balance) {
            super.withdraw(balance);
            this.overdraft = this.overdraft + (amount - balance);
        } else {
            super.withdraw(amount);
        }
        setAvailableBalance(available - amount);
        return true;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        setAvailableBalance(getAvailableBalance() + amount);
    }
}
