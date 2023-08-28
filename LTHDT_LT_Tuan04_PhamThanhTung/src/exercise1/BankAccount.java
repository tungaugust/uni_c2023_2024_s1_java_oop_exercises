/*
 *  @ (#) BankAccount.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise1;

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
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Không thể nạp tiền.");
            return;
        }
        this.balance = this.balance + amount;
        System.out.println("Nạp tiền thành công.");
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > this.balance) {
            System.out.println("Không thể rút tiền.");
            return;
        }
        this.balance = this.balance - amount;
        System.out.println("Rút tiền thành công.");
    }

    public void transfer(BankAccount other, double amount){
        // Kiểm tra số tiền muốn chuyển
        if (amount <= 0 || amount > this.balance) {
            System.out.println("Không thể chuyển tiền.");
            return;
        }
        // Chuyển tiền (rút) từ tài khoản gửi
        withdraw(amount);
        // Nhận tiền (nạp) từ tài khoản nhận
        other.deposit(amount);
        System.out.println("Chuyển tiền thành công.");
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return String.format("%-20s %-25s %15s", this.accountNumber, this.ownerName, decimalFormat.format(this.balance));
    }
}
