/*
 *  @ (#) BankingServices.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise15;

import java.text.DecimalFormat;

/**
 * Chương trình kiểm tra
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class BankingServices {
    public static void main(String[] args) {
        // Tài khoản ghi nợ
        Account account1 = new Account("1001-0000-1011", 5000.0);
        // Tài khoản tín dụng (hoặc tài khoản thấu chi)
        OverdraftAccount account2 = new OverdraftAccount("1001-0000-1012", 5000.0, 2000.0);
        // Tài khoản tiết kiệm
        Savings account3 = new Savings("1001-0000-1013", 20000.0, 0.06);
        // Tài khoản tiết kiệm có thời hạn (hoặc tài khoản tiền gửi có kỳ hạn)
        TermDepositAccount account4 = new TermDepositAccount("1001-0000-1014", 20000.0, 0.06, 12);

        //
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
        String headerLine;

        System.out.println("Kiểm tra tài khoản tiết kiệm");
        headerLine = String.format("%-30s | %20s", "Trạng thái", "Số dư");
        System.out.println(headerLine);
        System.out.printf("%-30s | %20s\n", "Khởi đầu", decimalFormat.format(account1.getBalance()));
        account1.deposit(3000.0);
        System.out.printf("%-30s | %20s\n", "Nạp 3000", decimalFormat.format(account1.getBalance()));
        account1.withdraw(7000.0);
        System.out.printf("%-30s | %20s\n", "Rút 7000", decimalFormat.format(account1.getBalance()));

        System.out.println("\nKiểm tra tài khoản tín dụng có giới hạn tín dụng là 2000.0");
        headerLine = String.format("%-30s | %20s | %20s", "Trạng thái", "Số dư", "Số dư khả dụng");
        System.out.println(headerLine);
        System.out.printf("%-30s | %20s | %20s\n", "Khởi đầu ", decimalFormat.format(account2.getBalance()),
                decimalFormat.format(account2.getAvailableBalance()));
        account2.deposit(3000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Nạp 3000", decimalFormat.format(account2.getBalance()),
                decimalFormat.format(account2.getAvailableBalance()));
        account2.withdraw(7000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Rút 7000", decimalFormat.format(account2.getBalance()),
                decimalFormat.format(account2.getAvailableBalance()));
        account2.withdraw(2000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Rút 2000", decimalFormat.format(account2.getBalance()),
                decimalFormat.format(account2.getAvailableBalance()));
        account2.deposit(1000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Nạp 1000", decimalFormat.format(account2.getBalance()),
                decimalFormat.format(account2.getAvailableBalance()));

        System.out.println("\nKiểm tra tài khoản tiết kiệm có lãi suất 6%/năm");
        headerLine = String.format("%-30s | %20s | %20s", "Trạng thái", "Số dư", "Tiền lãi");
        System.out.println(headerLine);
        System.out.printf("%-30s | %20s | %20s\n", "Khởi đầu ", decimalFormat.format(account3.getBalance()),
                decimalFormat.format(account3.getInterestAmount()));
        account3.deposit(3000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Nạp 3000", decimalFormat.format(account3.getBalance()),
                decimalFormat.format(account3.getInterestAmount()));
        account3.withdraw(7000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Rút 7000", decimalFormat.format(account3.getBalance()),
                decimalFormat.format(account3.getInterestAmount()));
        account3.addInterestToBalance();
        System.out.printf("%-30s | %20s | %20s\n", "Tiền lãi lần 1 (tháng đầu)", decimalFormat.format(account3.getBalance()),
                decimalFormat.format(account3.getInterestAmount()));
        account3.addInterestToBalance();
        System.out.printf("%-30s | %20s | %20s\n", "Tiền lãi lần 2 (tháng thứ 2)", decimalFormat.format(account3.getBalance()),
                decimalFormat.format(account3.getInterestAmount()));
        account3.addInterestToBalance();
        System.out.printf("%-30s | %20s | %20s\n", "Tiền lãi lần 3 (tháng thứ 3)", decimalFormat.format(account3.getBalance()),
                decimalFormat.format(account3.getInterestAmount()));

        System.out.println("\nKiểm tra tài khoản tiết kiệm có thời hạn 12 tháng với lãi suất 6%/năm");
        headerLine = String.format("%-30s | %20s | %20s", "Trạng thái", "Số dư", "Tiền lãi");
        System.out.println(headerLine);
        System.out.printf("%-30s | %20s | %20s\n", "Khởi đầu ", decimalFormat.format(account4.getBalance()),
                decimalFormat.format(account4.getInterestAmount()));
        account4.deposit(3000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Nạp 3000", decimalFormat.format(account4.getBalance()),
                decimalFormat.format(account4.getInterestAmount()));
        account4.withdraw(7000.0);
        System.out.printf("%-30s | %20s | %20s\n", "Rút 7000",decimalFormat.format(account4.getBalance()),
                decimalFormat.format(account4.getInterestAmount()));
        account4.addInterestToBalance();
        System.out.printf("%-30s | %20s | %20s\n", "Kết toán lần 1", decimalFormat.format(account4.getBalance()),
                decimalFormat.format(account4.getInterestAmount()));
        account4.addInterestToBalance();
        System.out.printf("%-30s | %20s | %20s\n", "Kết toán lần 2", decimalFormat.format(account4.getBalance()),
                decimalFormat.format(account4.getInterestAmount()));
        account4.addInterestToBalance();
        System.out.printf("%-30s | %20s | %20s\n", "Kết toán lần 3", decimalFormat.format(account4.getBalance()),
                decimalFormat.format(account4.getInterestAmount()));
    }
}
