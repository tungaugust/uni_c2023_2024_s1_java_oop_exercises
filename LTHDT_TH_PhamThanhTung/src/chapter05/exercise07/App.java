/*
 *  @ (#) App.java      1.0 04/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise07;

import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 04, 2023
 */
public class App {
    public static void main(String[] args) {
        DanhBaDienThoai danhBa = new DanhBaDienThoai();
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456789"), new DiaChi("A"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456781"), new DiaChi("A"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456782"), new DiaChi("C"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456783"), new DiaChi("B"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456784"), new DiaChi("C"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456785"), new DiaChi("D"));

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        SoDienThoai soDienThoai = null;
        DiaChi diaChi = null;

        while (flag) {
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t[ 1 ] Đăng kí một số điện thoại vào danh bạ");
            System.out.println("\t[ 2 ] Hiển thị danh bạ tăng dần theo số điện thoại");
            System.out.println("\t[ 3 ] Hiển thị danh bạ tăng dần theo địa chỉ");
            System.out.println("\t[ 4 ] Xoá một số điện thoại ra khỏi danh bạ");
            System.out.println("\t[ 5 ] Tra cứu các số điện thoại theo địa chỉ");
            System.out.println("\t[ 6 ] Tra cứu địa chỉ theo số điện thoại");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 6 ]: ");

            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }
            switch (option){
                case 1:
                    System.out.println("[ 1 ] Đăng kí một số điện thoại vào danh bạ");
                    System.out.print("Nhập số điện thoại muốn đăng kí: ");
                    input = scanner.nextLine().trim();
                    soDienThoai = new SoDienThoai(input);
                    System.out.print("Nhập địa chỉ đăng kí: ");
                    input = scanner.nextLine().trim();
                    diaChi = new DiaChi(input);
                    if (danhBa.dangKiSoDienThoai(soDienThoai, diaChi)) {
                        System.out.println("Đăng kí thành công.");
                    } else {
                        System.out.println("Đăng kí thất bại, số điện thoại đã được đăng kí trước đó.");
                    }
                    break;
                case 2:
                    System.out.println("[ 2 ] Hiển thị danh bạ tăng dần theo số điện thoại");
                    danhBa.hienThiDanhBaTangDanTheoSoDienThoai();
                    break;
                case 3:
                    System.out.println("[ 3 ] Hiển thị danh bạ tăng dần theo địa chỉ");
                    danhBa.hienThiDanhBaTangDanTheoDiaChi();
                    break;
                case 4:
                    System.out.println("[ 4 ] Xoá một số điện thoại ra khỏi danh bạ");
                    System.out.print("Nhập số điện thoại muốn đăng kí: ");
                    input = scanner.nextLine().trim();
                    soDienThoai = new SoDienThoai(input);
                    if (danhBa.xoaSoDienThoai(soDienThoai)) {
                        System.out.println("Xoá thành công.");
                    } else {
                        System.out.println("Xoá thất bại, số điện thoại không tồn tại.");
                    }
                    break;
                case 5:
                    System.out.println("[ 5 ] Tra cứu các số điện thoại theo địa chỉ");
                    danhBa.hienThiDanhBaTangDanTheoSoDienThoai();
                    break;
                case 6:
                    System.out.println("[ 6 ] Tra cứu địa chỉ theo số điện thoại");
                    System.out.print("Nhập số điện thoại: ");
                    input = scanner.nextLine().trim();
                    soDienThoai = new SoDienThoai(input);
                    diaChi = danhBa.traCuuTheoSoDienThoai(soDienThoai);
                    if (diaChi == null){
                        System.out.println("Số điện thoại không có trong danh bạ.");
                    } else {
                        System.out.println("Số điện thoại ["
                                + soDienThoai.getSoDienThoai()
                                + "] có địa chỉ cần tìm là ["
                                + diaChi.getDiaChi()
                                + "]");
                    }
                    break;
                case 0:
                    System.out.println("[ 0 ] Thoát MENU.");
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}
