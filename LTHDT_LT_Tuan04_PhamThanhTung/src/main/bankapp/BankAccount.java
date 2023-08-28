/*
 *  @ (#) BankAccount.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main.bankapp;

import java.text.DecimalFormat;

/**
 * Lớp tài khoản ngân hàng BankAccount
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount() {
        this.accountNumber = "0000-0000-0000";
        this.ownerName = "No name";
        this.balance = 0.0;
    }
    public BankAccount(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be greater than or equal to 0");
        }
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance = this.balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > this.balance) {
            throw new IllegalArgumentException("Amount must be greater than 0 and less than or equal to balance");
        }
        this.balance = this.balance - amount;
    }

    public void transfer(BankAccount other, double amount){
        // Chuyển tiền (rút) từ tài khoản gửi
        withdraw(amount);
        // Nhận tiền (nạp) từ tài khoản nhận
        other.deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.equals("")) {
            throw new IllegalArgumentException("The account number must not be null");
        }
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.equals("")) {
            throw new IllegalArgumentException("The owner name must not be null");
        }
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return String.format("%-20s | %-25s | %15s", this.accountNumber, this.ownerName, decimalFormat.format(this.balance));
    }
}
