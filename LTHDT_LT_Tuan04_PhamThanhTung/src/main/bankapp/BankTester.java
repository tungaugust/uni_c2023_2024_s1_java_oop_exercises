/*
 *  @ (#) BankTester.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main.bankapp;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Chương trình mô phỏng các giao dịch của ngân hàng
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class BankTester {
    public static void main(String[] args) {
        /* Bắt đầu MENU */
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào
        String headerLine = String.format("%-5s | %-20s | %-25s | %15s",
                "STT", "Số tài khoản", "Chủ tài khoản", "Số dư"
        );

        BankAccount bankAccount, otherAccount;
        String ownerName;
        String accountNumber;
        double amount;
        Bank bank = new Bank("IUH Bank", 10);
        bank.addNew("1001-1011-1100", "Lê Quang Nhân", 5000.0);
        bank.addNew("1001-1011-1101", "Trần Trọng Nghĩa", 6000.0);
        bank.addNew("1001-1011-1102", "Lý Hoàng Lễ", 4500.0);
        bank.addNew("1001-1011-1103", "Đinh Minh Trí", 3700.0);
        bank.addNew("1001-1011-1104", "Triệu Trung Dũng", 8900.0);
        bank.addNew("1001-1011-1105", "Nguyễn Trọng Tín", 7700.0);

        while (flag) {
            // Phần mô tả của Menu
            System.out.println("Welcome to " + bank.getName());
            System.out.println("1. Open new account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. The total balance of all bank accounts in the bank");
            System.out.println("6. Print all bank accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Phần xử lý tuỳ chọn cho Menu
            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }

            // Phần thân của Menu, chạy các lệnh phù hợp với tuỳ chọn tương ứng
            switch (option) {
                case 1:
                    System.out.println("Add new account");
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine().trim();
                    System.out.println("Enter account name:");
                    ownerName = scanner.nextLine().trim();
                    System.out.println("Enter balance:");
                    try {
                        amount = Double.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        amount = 0.0;
                    }
                    try {
                        bank.addNew(accountNumber, ownerName, amount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Deposit");
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine().trim();
                    System.out.println("Enter amount:");
                    try {
                        amount = Double.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        amount = 0.0;
                    }
                    bankAccount = bank.find(accountNumber);
                    if (bankAccount == null){
                        System.out.println("Account number does not exist");
                    } else {
                        try {
                            bankAccount.deposit(amount);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Transaction failed");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Withdraw");
                    System.out.println("Enter account number:");
                    accountNumber = scanner.nextLine().trim();
                    System.out.println("Enter amount:");
                    try {
                        amount = Double.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        amount = 0.0;
                    }
                    bankAccount = bank.find(accountNumber);
                    if (bankAccount == null){
                        System.out.println("Account number does not exist");
                    } else {
                        try {
                            bankAccount.withdraw(amount);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Transaction failed");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Transfer");
                    System.out.println("Enter account number of sender:");
                    accountNumber = scanner.nextLine().trim();
                    bankAccount = bank.find(accountNumber);
                    System.out.println("Enter account number of receiver:");
                    accountNumber = scanner.nextLine().trim();
                    otherAccount = bank.find(accountNumber);
                    System.out.println("Enter amount:");
                    try {
                        amount = Double.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        amount = 0.0;
                    }
                    if (bankAccount == null || otherAccount == null){
                        System.out.println("Account number does not exist");
                    } else {
                        try {
                            bankAccount.transfer(otherAccount, amount);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Transaction failed");
                        }
                    }
                    break;
                case 5:
                    System.out.println("The total balance of all bank accounts in the bank");
                    System.out.println("Total: " + decimalFormat.format(bank.getTotalBalance()));
                    break;
                case 6:
                    System.out.println("Print all bank accounts");
                    System.out.println(headerLine);
                    BankAccount[] accounts = bank.getAccounts();
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i] == null) {
                            break;
                        }
                        System.out.printf("%-5d | %s\n", i + 1, accounts[i]);
                    }
                    break;
                case 7:
                    System.out.println("Exit");
                    flag = false;
                    break;
                default: break;
            }
            System.out.println();
        }
        //
    }
}
