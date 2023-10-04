/*
 *  @ (#) App.java      1.0 04/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise03;

import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 04, 2023
 */
public class App {
    public static void main(String[] args) {
        KhachHang khachHang1 = new KhachHang("123456789", "Phạm Hoàng Quân", "Hà Nội", 50000.0);
        KhachHang khachHang2 = new KhachHang("123456788", "Lưu Gia Lâm", "Hồ Chí Minh", 70000.0);
        KhachHang khachHang3 = new KhachHang("123456785", "Lê Văn Võ", "Hà Nội", 60000.0);
        KhachHang khachHang4 = new KhachHang("123456783", "Đoàn Viết Nhân", "Hồ Chí Minh", 80000.0);
        KhachHang khachHang5 = new KhachHang("123456787", "Trương Hoàng Long", "Hà Nội", 40000.0);
        KhachHang khachHang6 = new KhachHang("123456784", "La Chung Ly", "Đà Nẵng", 45000.0);
        QuanLyHangDoi quanLyHangDoi = new QuanLyHangDoi();
        quanLyHangDoi.themKhachHang(khachHang1);
        quanLyHangDoi.themKhachHang(khachHang2);
        quanLyHangDoi.themKhachHang(khachHang3);
        quanLyHangDoi.themKhachHang(khachHang4);
        quanLyHangDoi.themKhachHang(khachHang5);
        quanLyHangDoi.themKhachHang(khachHang6);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        KhachHang khachHang = null;
        String soCMND;
        String tenKH;
        String tenGaDen;
        double giaTien;

        while (flag) {
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t[ 1 ] Thêm một khách hàng mới vào hàng đợi mua vé");
            System.out.println("\t[ 2 ] Bán một vé cho khách hàng. Chỉ bán cho người đăng ký trước");
            System.out.println("\t[ 3 ] Hiển thị danh sách khách hàng (đang chờ mua vé)");
            System.out.println("\t[ 4 ] Hủy một khách hàng ra khỏi danh sách (khách hàng không mua vé nữa)");
            System.out.println("\t[ 5 ] Thống kê tình hình bán vé");
            System.out.println("\t[ 6 ] Lưu danh sách vào file");
            System.out.println("\t[ 7 ] Hiển thị danh sách các ga đang chờ mua vé");
            System.out.println("\t[ 8 ] Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 8 ]: ");

            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }
            switch (option){
                case 1:
                    System.out.println("[ 1 ] Thêm một khách hàng mới vào hàng đợi mua vé");
                    System.out.print("Nhập số CMND: ");
                    soCMND = scanner.nextLine().trim();
                    System.out.print("Nhập tên khách hàng: ");
                    tenKH = scanner.nextLine().trim();
                    System.out.print("Nhập tên ga đến: ");
                    tenGaDen = scanner.nextLine().trim();
                    try {
                        System.out.print("Nhập giá vé: ");
                        giaTien = Double.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        giaTien = 0.0;
                    }
                    quanLyHangDoi.themKhachHang(new KhachHang(soCMND, tenKH, tenGaDen, giaTien));
                    break;
                case 2:
                    System.out.println("[ 2 ] Bán một vé cho khách hàng");
                    System.out.println(quanLyHangDoi.banVeChoKhachHang());
                    break;
                case 3:
                    System.out.println("[ 3 ] Hiển thị danh sách khách hàng (đang chờ mua vé)");
                    quanLyHangDoi.hienThiDanhSachKhachHang();
                    break;
                case 4:
                    System.out.println("[ 4 ] Hủy một khách hàng ra khỏi danh sách (khách hàng không mua vé nữa)");
                    System.out.print("Nhập số CMND của khách hàng muốn huỷ: ");
                    input = scanner.nextLine().trim();
                    khachHang = quanLyHangDoi.huyKhachHang(input);
                    if (khachHang == null) {
                        System.out.println("Không tìm thấy khách hàng có số CMND là " +  input + " trong danh sách chờ");
                    } else {
                        System.out.println(khachHang);
                    }
                    break;
                case 5:
                    System.out.println("[ 5 ] Thống kê tình hình bán vé");
                    quanLyHangDoi.thongKeTinhHinhBanVe();
                    break;
                case 6:
                    System.out.println("[ 6 ] Lưu danh sách vào file");
                    quanLyHangDoi.luuDanhSachKhachHangTrongHangDoi();
                    break;
                case 7:
                    System.out.println("[ 7 ] Hiển thị danh sách các ga đang chờ mua vé");
                    quanLyHangDoi.hienThiDanhSachCacGaDangChoMuaVe();
                    break;
                case 8:
                    System.out.println("[ 8 ] Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga");
                    quanLyHangDoi.hienThiDanhSachCacGaDangChoMuaVeVaSoVeTuongUng();
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
