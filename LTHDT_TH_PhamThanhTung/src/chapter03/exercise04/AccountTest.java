/*
 *  @ (#) AccountTest.java      1.0 24/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise04;

import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 24, 2023
 */
public class AccountTest {
    public static void main(String[] args) {
        AccountList list = new AccountList();
        Scanner scanner = new Scanner(System.in);

        Account account1 = new Account(100, "Teddy", 100000.0);
        Account account2 = new Account(200, "Jane", 40.0);
        Account account3 = new Account(300, "Barbara", 500000.0);
        list.add(account1);
        list.add(account2);
        list.add(account3);

        /* Bắt đầu MENU */
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        Account account;    // đối tượng tài khoản
        Account otherAccount;   // dối tượng tài khoản nhận tiền
        long accID; // số tài khoản
        String accName; // tên tài khoản
        double accBalance; // số dư, số tiền
        int initializationAccountWay = 0;   // cách khởi tạo đối tượng Account
        String headerLine;  // dòng tên trường khi in danh sách tài khoản
        while (flag) {
            // Phần mô tả của Menu
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t[ 1 ] Thêm tài khoản mới.");
            System.out.println("\t[ 2 ] Số lượng tài khoản hiện có.");
            System.out.println("\t[ 3 ] In thông tin của tất cả tài khoản.");
            System.out.println("\t[ 4 ] Nạp tiền.");
            System.out.println("\t[ 5 ] Rút tiền.");
            System.out.println("\t[ 6 ] Chuyển tiền.");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 6 ]: ");

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
                    System.out.println("[ 1 ] Thêm tài khoản mới.");
                    System.out.print(">>> Nhập số tài khoản (lớn hơn 0 và khác 999999): ");
                    input = scanner.nextLine().trim();
                    try {
                        accID = Long.valueOf(input);
                    } catch (NumberFormatException e) {
                        initializationAccountWay += 1;
                        accID = 999999l;
                    }
                    System.out.print(">>> Nhập tên tài khoản (chuỗi khác rỗng): ");
                    accName = scanner.nextLine().trim();
                    if (accName.equals("")) {
                        initializationAccountWay += 2;
                    }
                    System.out.print(">>> Nhập số tiền (>= 50.0) (đơn vị: đồng): ");
                    input = scanner.nextLine().trim();
                    try {
                        accBalance = Double.valueOf(input);
                    } catch (NumberFormatException e) {
                        initializationAccountWay += 4;
                        accBalance = 0.0;
                    }
                    // Tạo đối tượng Account
                    switch (initializationAccountWay){
                        case 7: // sử dụng default constructor
                            account = new Account(); break;
                        case 4: case 5: case 6: // sử dụng constructor 2 tham số
                            account = new Account(accID, accName); break;
                        default: // sử dụng constructor 3 tham số
                            account = new Account(accID, accName, accBalance); break;
                    }
                    initializationAccountWay = 0;   // reset
                    // Thêm đối tượng Account mới vào danh sách
                    if (list.add(account)){
                        System.out.println(">>> Tài khoản đã được thêm vào danh sách thành công.");
                    } else {
                        System.out.println(">>> Danh sách đã đầy, vui lòng kiểm tra lại trước khi tạo tài khoản mới.");
                    }
                    break;
                case 2:
                    System.out.println("[ 2 ] Số lượng tài khoản hiện có.");
                    System.out.println(">>> " + list.getSize() + " tài khoản");
                    break;
                case 3:
                    System.out.println("[ 3 ] Thông tin của tất cả tài khoản có trong danh sách.");
                    if (list.getSize() > 0) {
                        headerLine = String.format("%-5s | %-10s | %-25s | %20s",
                                "STT", "Số TK", "Tên TK", "Số dư"
                        );
                        System.out.println(headerLine);
                        String lineSymbol = "=";
                        for (int i = 0; i < headerLine.length(); i++) {
                            System.out.print(lineSymbol);
                        }
                        System.out.println();
                        list.printList();
                    } else {
                        System.out.println(">>> Chưa có tài khoản nào trong danh sách.");
                    }
                    break;
                case 4:
                    System.out.println("[ 4 ] Nạp tiền.");
                    System.out.print(">>> Nhập số tài khoản (lớn hơn 0 và khác 999999): ");
                    input = scanner.nextLine().trim();
                    try {
                        accID = Long.valueOf(input);
                        if (accID > 0 && accID != 999999) {
                            account = list.find(accID);
                            if (account != null) {
                                System.out.print(">>> Nhập số tiền nạp (đơn vị: đồng): ");
                                input = scanner.nextLine().trim();
                                try {
                                    accBalance = Double.valueOf(input);
                                    account.napTien(accBalance);
                                } catch (NumberFormatException e) {
                                    System.out.println(">>> Số tiền cần nạp không hợp lệ.");
                                }
                            } else {
                                System.out.println(">>> Số tài khoản không tồn tài.");
                            }
                        } else {
                            System.out.println(">>> Số tài khoản đã nhập không hợp lệ.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(">>> Số tài khoản đã nhập không hợp lệ.");
                    }
                    break;
                case 5:
                    System.out.println("[ 5 ] Rút tiền.");
                    System.out.print(">>> Nhập số tài khoản (lớn hơn 0 và khác 999999): ");
                    input = scanner.nextLine().trim();
                    try {
                        accID = Long.valueOf(input);
                        if (accID > 0 && accID != 999999) {
                            account = list.find(accID);
                            if (account != null) {
                                System.out.print(">>> Nhập số tiền muốn rút (đơn vị: đồng): ");
                                input = scanner.nextLine().trim();
                                try {
                                    accBalance = Double.valueOf(input);
                                    account.rutTien(accBalance);
                                } catch (NumberFormatException e) {
                                    System.out.println(">>> Số tiền muốn rút không hợp lệ.");
                                }
                            } else {
                                System.out.println(">>> Số tài khoản không tồn tài.");
                            }
                        } else {
                            System.out.println(">>> Số tài khoản đã nhập không hợp lệ.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(">>> Số tài khoản đã nhập không hợp lệ.");
                    }
                    break;
                case 6:
                    System.out.println("[ 6 ] Chuyển tiền.");
                    System.out.print(">>> Nhập số tài khoản gửi tiền (lớn hơn 0 và khác 999999): ");
                    input = scanner.nextLine().trim();
                    try {
                        accID = Long.valueOf(input);
                        if (accID > 0 && accID != 999999) {
                            account = list.find(accID);
                            if (account != null) {
                                //
                                System.out.print(">>> Nhập số tài khoản nhận tiền (lớn hơn 0 và khác 999999): ");
                                input = scanner.nextLine().trim();
                                accID = Long.valueOf(input);
                                if (accID > 0 && accID != 999999) {
                                    otherAccount = list.find(accID);
                                    if (otherAccount != null) {
                                        System.out.print(">>> Nhập số tiền muốn chuyển (đơn vị: đồng): ");
                                        input = scanner.nextLine().trim();
                                        try {
                                            accBalance = Double.valueOf(input);
                                            account.chuyenKhoan(otherAccount, accBalance);
                                        } catch (NumberFormatException e) {
                                            System.out.println(">>> Số tiền muốn chuyển không hợp lệ.");
                                        }
                                    } else {
                                        System.out.println(">>> Số tài khoản không tồn tài.");
                                    }
                                } else {
                                    System.out.println(">>> Số tài khoản đã nhập không hợp lệ.");
                                }
                            } else {
                                System.out.println(">>> Số tài khoản không tồn tài.");
                            }
                        } else {
                            System.out.println(">>> Số tài khoản đã nhập không hợp lệ.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(">>> Số tài khoản đã nhập không hợp lệ.");
                    }
                    break;
                case 0:
                    System.out.println("[ 0 ] Thoát MENU.");
                    flag = false;
                    break;
                default: break;
            }
        }
        /* Kết thúc MENU */
    }

    public static boolean isNumeric(String number) {
        if (number == null){
            return false;
        }
        return number.matches("-?\\d+(\\.\\d+)?");
    }
}
