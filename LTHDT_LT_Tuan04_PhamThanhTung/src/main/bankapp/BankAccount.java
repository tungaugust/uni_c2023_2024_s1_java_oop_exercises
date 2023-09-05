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

    /**
     * Default constructor của lớp BankAccount
     */
    public BankAccount() {
        this("0000-0000-0000", "No name", 0.0);
    }

    /**
     * Constructor 3 tham số của lớp BankAccount
     * @param accountNumber: Số tài khoản
     * @param ownerName: Tên chủ tài khoản
     * @param balance: Số dư, lớn hơn hoặc bằng 0
     */
    public BankAccount(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be greater than or equal to 0");
        }
        this.balance = balance;
    }

    /**
     * Phương thức gửi tiền
     * @param amount: số tiền gửi, lớn hơn 0
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance = this.balance + amount;
    }

    /**
     * Phương thức gửi tiền
     * @param amount: số tiền gửi và lớn hơn 0
     */
    public void withdraw(double amount) {
        if (amount <= 0 || amount > this.balance) {
            throw new IllegalArgumentException("Amount must be greater than 0 and less than or equal to balance");
        }
        this.balance = this.balance - amount;
    }

    /**
     * Phương thức chuyển tiền
     * @param amount: số tiền chuyền
     */
    public void transfer(BankAccount other, double amount){
        // Chuyển tiền (rút) từ tài khoản gửi
        withdraw(amount);
        // Nhận tiền (nạp) từ tài khoản nhận
        other.deposit(amount);
    }

    /**
     * Phương thức truy vấn số dư
     * @return Trả về số dư
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Phương thức truy vấn số tài khoản
     * @return Trả về số tài khoản
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Phương thức chỉnh sửa (đặt) số tài khoản
     * @param accountNumber: Số tài khoản muốn đặt
     */
    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().equals("")) {
            throw new IllegalArgumentException("The account number must not be null");
        }
        this.accountNumber = accountNumber;
    }

    /**
     * Phương thức truy vấn tên chủ tài khoản
     * @return Trả về tên chủ tài khoản
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Phương thức chỉnh sửa (đặt) tên chủ tài khoản
     * @param ownerName: Tên chủ tài khoản muốn đặt
     */
    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().equals("")) {
            throw new IllegalArgumentException("The owner name must not be null");
        }
        this.ownerName = ownerName;
    }

    /**
     * Phương thức truy vấn thông tin tài khoản
     * @return Trả về thông tin tài khoản dạng chuỗi
     */
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
        return String.format("%-20s | %-25s | %15s", this.accountNumber, this.ownerName, decimalFormat.format(this.balance));
    }
}
