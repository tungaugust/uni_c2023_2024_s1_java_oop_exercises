/*
 *  @ (#) CDTest.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise05;

import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public class CDTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CDList list = new CDList();
        CD cd1 = new CD(100, "Rock", 10, 120000.0);
        CD cd2 = new CD(200, "Jazz", 23, 540000.0);
        CD cd3 = new CD(300, "Bolero", 20, 520000.0);
        CD cd4 = new CD();
        list.add(cd1);
        list.add(cd2);
        list.add(cd3);
        list.add(cd4);

        /* Bắt đầu MENU */
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào
        String headerLine;  // dòng tên trường khi in danh sách
        int initializationFlag = 0;   // cách khởi tạo đối tượng

        CD cd;  // đối tượng CD
        long maCD;  // mã CD
        String tuaCD;   // tựa CD
        int soBaiHat;   // số bài hát trong CD
        double giaThanh; // giá thành CD

        while (flag) {
            // Phần mô tả của Menu
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t[ 1 ] Thêm CD mới vào danh sách.");
            System.out.println("\t[ 2 ] Số lượng CD có trong danh sách.");
            System.out.println("\t[ 3 ] Tổng giá thành của tất cả CD trong danh sách.");
            System.out.println("\t[ 4 ] Sắp xếp danh sách theo giá thành giảm dần.");
            System.out.println("\t[ 5 ] Sắp xếp danh sách theo tựa CD tăng dần.");
            System.out.println("\t[ 6 ] In thông tin của tất cả CD trong danh sách.");
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
                    System.out.println("[ 1 ] Thêm CD mới vào danh sách.");
                    System.out.print(">>> Nhập mã CD (lớn hơn 0 và khác 999999): ");
                    input = scanner.nextLine().trim();
                    try {
                        maCD = Long.valueOf(input);
                    } catch (NumberFormatException e) {
                        initializationFlag += 1;
                        maCD = 999999l;
                    }
                    System.out.print(">>> Nhập tên tựa CD (chuỗi khác rỗng): ");
                    tuaCD = scanner.nextLine().trim();
                    if (tuaCD.equals("")) {
                        initializationFlag += 2;
                    }
                    System.out.print(">>> Nhập số bài hát có trong CD (lớn hơn 0): ");
                    input = scanner.nextLine().trim();
                    try {
                        soBaiHat = Integer.valueOf(input);
                    } catch (NumberFormatException e) {
                        initializationFlag += 4;
                        soBaiHat = 0;
                    }
                    System.out.print(">>> Nhập giá thành của CD (lớn hơn 0) (đơn vị: đồng): ");
                    input = scanner.nextLine().trim();
                    try {
                        giaThanh = Double.valueOf(input);
                    } catch (NumberFormatException e) {
                        initializationFlag += 8;
                        giaThanh = 0.0;
                    }
                    // Tạo đối tượng Account
                    try {
                        if (initializationFlag == 15) { // sử dụng default constructor
                            cd = new CD();
                        } else {    // sử dụng constructor 3 tham số
                            cd = new CD(maCD, tuaCD, soBaiHat, giaThanh);
                        }
                    } catch (RuntimeException e) {
                        cd = null;
                    }
                    initializationFlag = 0;   // reset
                    // Thêm đối tượng Account mới vào danh sách
                    if (cd == null) {
                        System.out.println(">>> Tham số không hợp lệ, CD không thể được tạo.");
                    } else {
                        if (list.add(cd)){
                            System.out.println(">>> CD mới đã được thêm vào danh sách thành công.");
                        } else {
                            System.out.println(">>> CD mới được thêm vào danh sách không thành công.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("[ 2 ] Số lượng CD có trong danh sách.");
                    System.out.println(">>> " + list.getSize() + " CD");
                    break;
                case 3:
                    System.out.println("[ 3 ] Tổng giá thành của tất cả CD trong danh sách.");
                    System.out.println(">>> " + list.totalPrice());
                    break;
                case 4:
                    System.out.println("[ 4 ] Sắp xếp danh sách theo giá thành giảm dần.");
                    list.sortDescendingListByPrice();
                    break;
                case 5:
                    System.out.println("[ 5 ] Sắp xếp danh sách theo tựa CD tăng dần.");
                    list.sortAscendingListByTitle();
                    break;
                case 6:
                    System.out.println("[ 6 ] In thông tin của tất cả CD trong danh sách.");
                    if (list.getSize() > 0) {
                        headerLine = String.format("%-5s | %-10s | %-25s | %15s | %20s",
                                "STT", "Mã CD", "Tựa CD", "Số bài hát", "Giá thành"
                        );
                        System.out.println(headerLine);
                        String lineSymbol = "=";
                        for (int i = 0; i < headerLine.length(); i++) {
                            System.out.print(lineSymbol);
                        }
                        System.out.println();
                        list.printList();
                    } else {
                        System.out.println(">>> Chưa có CD nào trong danh sách.");
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
}
