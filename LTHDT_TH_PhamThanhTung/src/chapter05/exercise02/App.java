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

        Phong phong = null;
        int type;
        String maPhong;
        String dayNha;
        double dienTich;
        int soLuongBongDen;
        boolean coThietBi = false;
        int soLuongMayTinh;


        while (flag) {
            // Phần mô tả của Menu
            System.out.println("\n\n---------- QUAN LY PHONG HOC ----------");
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
                    System.out.print("Nhập 1, 2 hoặc 3 để chọn loại phòng cần thêm (1-Phòng lý thuyết (mặc định); 2-Phòng máy tính; 3-Phòng thí nghiệm): ");
                    try {
                        type = Integer.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        type = 1;
                    }
                    System.out.print("Nhập mã phòng: " );
                    maPhong = scanner.nextLine().trim();
                    System.out.print("Nhập tên dãy nhà: " );
                    dayNha = scanner.nextLine().trim();
                    System.out.print("Nhập diện tích (m^2): " );
                    try {
                        dienTich = Double.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        dienTich = 0.0;
                    }
                    System.out.print("Nhập số lượng bóng đèn: " );
                    try {
                        soLuongBongDen = Integer.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        soLuongBongDen = 0;
                    }
                    switch (type){
                        case 2:
                            System.out.print("Nhập số lượng máy tính: " );
                            try {
                                soLuongMayTinh = Integer.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                soLuongMayTinh = 0;
                            }
                            phong = new PhongMayTinh(maPhong, dayNha, dienTich, soLuongBongDen, soLuongMayTinh);
                            break;
                        case 3:
                            System.out.print("Phòng có bồn rửa tay hay không? (C-Nếu có; K-Nếu không có (mặc định)): " );
                            input = scanner.nextLine().trim();
                            if (input.equalsIgnoreCase("C")) {
                                coThietBi = true;
                            }
                            phong = new PhongThiNghiem(maPhong, dayNha, dienTich, soLuongBongDen, coThietBi);
                            break;
                        default:
                            System.out.print("Phòng có máy chiếu hay không? (C-Nếu có; K-Nếu không có (mặc định)): " );
                            input = scanner.nextLine().trim();
                            if (input.equalsIgnoreCase("C")) {
                                coThietBi = true;
                            }
                            phong = new PhongLyThuyet(maPhong, dayNha, dienTich, soLuongBongDen, coThietBi);
                            break;
                    }
                    if (danhSachPhong.themPhong(phong)){
                        System.out.println("Thêm phòng thành công");
                    } else {
                        System.out.println("Thêm phòng không thành công");
                    }
                    break;
                case 2:
                    System.out.println("[ 2 ] Tìm kiếm một phòng học nào đó khi biết mã phòng");
                    System.out.print("Nhập mã phòng muốn tìm: ");
                    maPhong = scanner.nextLine().trim();
                    phong = danhSachPhong.timPhongTheoMaPhong(maPhong);
                    if (phong == null){
                        System.out.println("Không tìm thấy phòng với mã phòng " + maPhong);
                    } else {
                        System.out.println(phong);
                    }
                    break;
                case 3:
                    System.out.println("[ 3 ] In toàn bộ danh sách các phòng học");
                    danhSachPhong.inDanhSachTatCaPhong();
                    break;
                case 4:
                    System.out.println("[ 4 ] In danh sách các phòng học đạt chuẩn");
                    danhSachPhong.inDanhSachCacPhongDatChuan();
                    break;
                case 5:
                    System.out.println("[ 5 ] Sắp xếp danh sách tăng dần theo cột dãy nhà");
                    danhSachPhong.sapXepDanhSachTheoDayNha();
                    break;
                case 6:
                    System.out.println("[ 6 ] Sắp xếp danh sách giảm dần theo cột diện tích");
                    danhSachPhong.sapXepDanhSachGiamDanTheoDienTich();
                    break;
                case 7:
                    System.out.println("[ 7 ] Sắp xếp danh sách tăng dần theo cột số bóng đèn");
                    danhSachPhong.sapXepDanhSachTheoBongDen();
                    break;
                case 8:
                    System.out.println("[ 8 ] Cập nhật số máy tính cho một phòng máy tính nào đó khi biết mã phòng");
                    System.out.print("Nhập mã phòng máy tính: ");
                    maPhong = scanner.nextLine().trim();
                    System.out.print("Nhập số lượng máy tính muốn thay đổi: " );
                    try {
                        soLuongMayTinh = Integer.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        soLuongMayTinh = 0;
                    }
                    if (danhSachPhong.capNhatSoMayTinh(maPhong, soLuongMayTinh)){
                        System.out.println("Cập nhật thành công");
                    } else {
                        System.out.println("Cập nhật không thành công");
                    }
                    break;
                case 9:
                    System.out.println("[ 9 ] Xóa một phòng học nào đó khi biết mã phòng");
                    System.out.print("Nhập mã phòng muốn xoá: ");
                    maPhong = scanner.nextLine().trim();
                    if (danhSachPhong.xoaPhong(maPhong)){
                        System.out.println("Xoá phòng thành công");
                    } else {
                        System.out.println("Xoá phòng không thành công");
                    }
                    break;
                case 10:
                    System.out.println("[ 10 ] In ra tổng số phòng học");
                    System.out.println("Tổng số phòng đang quản lý là " + danhSachPhong.tongSoPhong() + " phòng");
                    break;
                case 11:
                    System.out.println("[ 11 ] In danh sách các phòng máy có 60 máy");
                    danhSachPhong.inDanhSachPhongMayTinhCo60May();
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
