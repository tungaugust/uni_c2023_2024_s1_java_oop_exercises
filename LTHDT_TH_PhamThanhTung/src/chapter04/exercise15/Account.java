/*
 *  @ (#) Account.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise15;

/**
 * Lớp Account là lớp thể hiển tài khoản ngân hàng | TÀI KHOẢN GHI NỢ
 * Chú ý: Số dư tối thiểu trong lớp này và các dẫn xuất của nó bằng 0.
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class Account {
    private double balance; // số dư
    private String accID;   // số tài khoản

    public Account(String accID, double balance) {
        setBalance(balance);
        if (accID.equals("")) {
            throw new RuntimeException("Account ID cannot be a empty string.");
        }
        this.accID = accID;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = (balance < 0) ? 0.0 : balance;
    }

    /**
     * Rút tiền
     * @param amount: số tiền rút
     * @return Trả về true khi rút tiền thành công, và ngược lại trả về false.
     */
    public boolean withdraw(double amount) {
        double diff = getBalance() - amount;
        if (diff < 0) {
            return false;
        }
        setBalance(diff);
        return true;
    }

    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }
}
