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

    /**
     * Default constructor của lớp Bank
     */
    public Bank() {
        this("No name", 10);
    }

    /**
     * Constructor 2 tham số của lớp Bank
     * @param name: Tên của ngân hàng
     * @param numberOfAccount: Số tài khoản ngân hàng có thể chứa
     */
    public Bank(String name, int numberOfAccount) {
        setName(name);
        if (numberOfAccount <= 0) {
            throw new IllegalArgumentException("Number of accounts must be greater than 0");
        }
        this.accounts = new BankAccount[numberOfAccount];
    }

    /**
     * Phương thức mở một tài khoản mới và thêm vào danh sách các tài khoản ngân hàng
     * @param accountNumber: Số tài khoản
     * @param ownerName: Tên chủ tài khoản
     * @param balance: Số dư
     */
    public void addNew(String accountNumber, String ownerName, double balance) {
        if (this.accounts[this.accounts.length - 1] != null){
            throw new IllegalArgumentException("Bank is full");
        }
        for (int i = 0; i < this.accounts.length; i++) {
            if (this.accounts[i] != null) {
                // Kiểm tra số tài khoản có tồn tại hay chưa
                if (this.accounts[i].getAccountNumber().equals(accountNumber)) {
                    throw new IllegalArgumentException("Account number already exists");
                }
            } else {
                this.accounts[i] = new BankAccount(accountNumber, ownerName, balance);
                break;
            }
        }
    }

    // T

    /**
     * Phương thức tìm một tài khoản ngân hàng theo số tài khoản
     * @param accountNumber: Số tài khoản cần tìm
     * @return Trả về một đối tượng BankAccount có số tài khoản cần tìm, nếu không tìm thấy thì trả về null
     */
    public BankAccount find(String accountNumber) {
        BankAccount bankAccount;
        for (int i = 0; i < this.accounts.length; i++) {
            bankAccount = this.accounts[i];
            if (bankAccount == null) {
                return null;
            }
            if (bankAccount.getAccountNumber().equals(accountNumber.trim())) {
                return bankAccount;
            }
        }
        return null;
    }

    /**
     * Phương thức tính tổng số tiền trong tất cả các tài khoản ngân hàng
     * @return Trả về tổng số dư của tất cả các tài khoản trong danh sách các tài khoản của ngân hàng
     */
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

    /**
     * Phương thức truy vấn số tài khoản có trong ngân hàng
     * @return Trả về số lượng tài khoản có trong ngân hàng
     */
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

    /**
     * Phương thức truy vấn danh sách các tài khoản có trong ngân hàng
     * @return Trả về một mảng chứa các đối tượng thuộc lớp BankAccount
     */
    public BankAccount[] getAccounts() {
        return accounts;
    }

    /**
     * Phương thức truy vấn tên ngân hàng
     * @return Trả về tên ngân hàng
     */
    public String getName() {
        return name;
    }

    /**
     * Phương thức chỉnh sửa (đặt) tên ngân hàng
     * @param name: Tên ngân hàng muốn đặt
     */
    public void setName(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("The bank name must not be null");
        }
        this.name = name;
    }
}
