/*
 *  @ (#) Bank.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main.bankapp;

/**
 * Lớp ngân hàng Bank
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class Bank {
    private String name;
    private BankAccount[] accounts;

    public Bank() {
        this.name = "No name";
        this.accounts = new BankAccount[10];
    }

    public Bank(String name, int numberOfAccount) {
        setName(name);
        if (numberOfAccount <= 0) {
            throw new IllegalArgumentException("Number of accounts must be greater than 0");
        }
        this.accounts = new BankAccount[numberOfAccount];
    }

    // Mở một tài khoản mới và thêm vào danh sách các tài khoản ngân hàng
    public void addNew(String accountNumber, String ownerName, double balance) {
        if (this.accounts[this.accounts.length - 1] != null){
            throw new IllegalArgumentException("Bank is full");
        }
        BankAccount bankAccount;
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] != null) {
                if (this.accounts[i].getAccountNumber().equals(accountNumber)) {
                    throw new IllegalArgumentException("Account number already exists");
                }
            } else {
                this.accounts[i] = new BankAccount(accountNumber, ownerName, balance);
                break;
            }
        }
    }

    // Tìm một tài khoản ngân hàng theo số tài khoản.
    public BankAccount find(String accountNumber) {
        BankAccount bankAccount;
        for (int i = 0; i < this.accounts.length; i++) {
            bankAccount = this.accounts[i];
            if (bankAccount == null) {
                return null;
            }
            if (bankAccount.getAccountNumber().equals(accountNumber)) {
                return bankAccount;
            }
        }
        return null;
    }

    // Tính tổng số tiền trong tất cả các tài khoản ngân hàng
    public double getTotalBalance() {
        double sum = 0.0;
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] == null) {
                break;
            }
            sum += this.accounts[i].getBalance();
        }
        return sum;
    }

    // Tính số tài khoản có trong ngân hàng
    public int getNumberOfAccounts() {
        int count = 0;
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] == null) {
                break;
            }
            count++;
        }
        return count;
    }

    public BankAccount[] getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("The bank name must not be null");
        }
        this.name = name;
    }
}
