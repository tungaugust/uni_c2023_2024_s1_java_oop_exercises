/*
 *  @ (#) App.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise02;

import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public class App {
    public static void main(String[] args) {
        Phong phong1 = new PhongLyThuyet("P001", "B", 50, 20, true);
        Phong phong2 = new PhongLyThuyet("P002", "A", 50, 20, false);
        Phong phong3 = new PhongLyThuyet("P003", "B", 50, 4, true);
        Phong phong4 = new PhongThiNghiem("P004", "C", 50, 20, true);
        Phong phong5 = new PhongThiNghiem("P005", "B", 50, 15, false);
        Phong phong6 = new PhongThiNghiem("P006", "A", 70, 10, true);
        Phong phong7= new PhongMayTinh("P007", "C", 50, 20, 100);
        Phong phong8= new PhongMayTinh("P008", "A", 50, 12, 60);
        Phong phong9= new PhongMayTinh("P009", "B", 50, 3, 75);
        Phong phong10= new PhongMayTinh("P008", "A", 50, 30, 60);
        QuanLyPhong danhSachPhong = new QuanLyPhong();
        danhSachPhong.themPhong(phong1);
        danhSachPhong.themPhong(phong2);
        danhSachPhong.themPhong(phong3);
        danhSachPhong.themPhong(phong4);
        danhSachPhong.themPhong(phong5);
        danhSachPhong.themPhong(phong6);
        danhSachPhong.themPhong(phong7);
        danhSachPhong.themPhong(phong8);
        danhSachPhong.themPhong(phong9);
        danhSachPhong.themPhong(phong10);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        while (flag) {
            // Phần mô tả của Menu
            System.out.println("\n\n---------- TRUE LOVE COMPANY ----------");
            System.out.println("\t[ 1 ] Thêm một phòng học vào danh sách");
            System.out.println("\t[ 2 ] Tìm kiếm một phòng học nào đó khi biết mã phòng");
            System.out.println("\t[ 3 ] In toàn bộ danh sách các phòng học");
            System.out.println("\t[ 4 ] In danh sách các phòng học đạt chuẩn");
            System.out.println("\t[ 5 ] Sắp xếp danh sách tăng dần theo cột dãy nhà");
            System.out.println("\t[ 6 ] Sắp xếp danh sách giảm dần theo cột diện tích");
            System.out.println("\t[ 7 ] Sắp xếp danh sách tăng dần theo cột số bóng đèn");
            System.out.println("\t[ 8 ] Cập nhật số máy tính cho một phòng máy tính nào đó khi biết mã phòng");
            System.out.println("\t[ 9 ] Xóa một phòng học nào đó khi biết mã phòng");
            System.out.println("\t[ 10 ] In ra tổng số phòng học");
            System.out.println("\t[ 11 ] In danh sách các phòng máy có 60 máy");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 11 ]: ");

            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }

            switch (option){
                case 1:
                    System.out.println("[ 1 ] Thêm một phòng học vào danh sách");
                    System.out.println("Nhân viên được chọn: " );
                    break;
                case 2:
                    System.out.println("[ 2 ] Tìm kiếm một phòng học nào đó khi biết mã phòng");
                    System.out.println("Tên ngẫu nhiên được chọn cho sản phẩm mới: ");
                    break;
                case 3:
                    System.out.println("[ 3 ] Đặt tên sản phẩm mới theo tên phổ biến của tất cả nhân viên.");
                    System.out.println("Tên phổ biến được chọn để đặt tên cho sản phẩm mới: " );
                    break;
                case 4:
                    System.out.println("[ 4 ] Đăng kí đi du lịch cho nhân viên.");
                    System.out.print("Nhập mã nhân viên đăng kí đi du lịch: ");
                    input = scanner.nextLine().trim();

                    break;
                case 5:
                    System.out.println("[ 5 ] Sắp xếp danh sách khách hàng với thứ tự tăng dần theo doanh số.");

                    break;
                case 6:
                    System.out.println("[ 6 ] In ra danh sách nhân viên.");

                    break;
                case 7:
                    System.out.println("[ 7 ] In ra danh sách khách hàng.");

                    break;
                case 8:
                    System.out.println("[ 8 ] In ra danh sách nhân viên đã đăng kí đi du lịch.");

                    break;
                case 9:
                    System.out.println("[ 8 ] In ra danh sách nhân viên đã đăng kí đi du lịch.");

                    break;
                case 10:
                    System.out.println("[ 8 ] In ra danh sách nhân viên đã đăng kí đi du lịch.");

                    break;
                case 11:
                    System.out.println("[ 8 ] In ra danh sách nhân viên đã đăng kí đi du lịch.");

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
