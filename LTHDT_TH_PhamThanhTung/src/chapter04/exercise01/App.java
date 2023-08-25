/*
 *  @ (#) App.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise01;

import chapter03.exercise05.CD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HoaDonList list = new HoaDonList();

        int soNgayChuyenDoi;
        HoaDonThuePhong hoaDon1, hoaDon2, hoaDon3;
        try {
            hoaDon1 = new HoaDonTheoGio("HD003", LocalDate.of(2023, 9, 12),
                    "Phạm Công Khanh", "P008X", 200000.0, 29);
        } catch (UncheckedException e) {
            soNgayChuyenDoi = (int) Math.ceil(Double.valueOf(e.getMessage()) / 24);
            hoaDon1 = new HoaDonTheoNgay("HD003", LocalDate.of(2023, 9, 12),
                    "Phạm Công Khanh", "P008X", 200000.0, soNgayChuyenDoi);
        }
        try {
            hoaDon2 = new HoaDonTheoGio("HD004", LocalDate.of(2023, 10, 12),
                    "Mai Văn Hưng", "P009V", 200000.0, 36);
        } catch (UncheckedException e) {
            soNgayChuyenDoi = (int) Math.ceil(Double.valueOf(e.getMessage()) / 24);
            hoaDon2 = new HoaDonTheoNgay("HD004", LocalDate.of(2023, 10, 12),
                    "Mai Văn Hưng", "P009V", 200000.0, soNgayChuyenDoi);
        }
        try {
            hoaDon3 = new HoaDonTheoGio("HD002", LocalDate.of(2023, 9, 11),
                    "Trần Hoàng Long", "P010F", 180000.0, 15);
        } catch (UncheckedException e) {
            soNgayChuyenDoi = (int) Math.ceil(Double.valueOf(e.getMessage()) / 24);
            hoaDon3 = new HoaDonTheoNgay("HD002", LocalDate.of(2023, 9, 11),
                    "Trần Hoàng Long", "P010F", 180000.0, soNgayChuyenDoi);
        }
        HoaDonThuePhong hoaDon4 = new HoaDonTheoNgay("HD001", LocalDate.of(2023, 12, 12),
                "Nguyễn Huy Quang", "P005F", 150000.0, 7);
        HoaDonThuePhong hoaDon5 = new HoaDonTheoNgay("HD008", LocalDate.of(2023, 9, 10),
                "Lê Bá Tuấn", "P004X", 170000.0, 9);
        HoaDonThuePhong hoaDon6 = new HoaDonTheoNgay("HD006", LocalDate.of(2023, 10, 10),
                "Đoàn Trung Quân", "P007V", 190000.0, 3);

        list.add(hoaDon1);
        list.add(hoaDon2);
        list.add(hoaDon3);
        list.add(hoaDon4);
        list.add(hoaDon5);
        list.add(hoaDon6);

        // Nhập hóa đơn thuê phòng.
        HoaDonThuePhong hoaDon;
        String input;
        String loaiPhong;
        String tenHoaDon;
        String maHoaDon;
        String maPhong;
        LocalDate ngay;
        double donGia;
        int soLuong;
        System.out.print(">>> Nhập số 1 nếu muốn phòng theo giờ (mặc định bỏ trống theo ngày): ");
        input = scanner.nextLine().trim();
        if (input.equals("1")) {
            loaiPhong = HoaDonThuePhong.GIO;
        } else {
            loaiPhong = HoaDonThuePhong.NGAY;
        }

        System.out.print(">>> Nhập mã hoá đơn: ");
        maHoaDon = scanner.nextLine().trim();
        System.out.print(">>> Nhập tên đăng kí phòng: ");
        tenHoaDon = scanner.nextLine().trim();
        System.out.print(">>> Nhập ngày đăng kí (ví dụ: 01/09/2023): ");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        input = scanner.nextLine().trim();
        if (input.equals("")) {
            ngay = LocalDate.now();
        } else {
            ngay = LocalDate.parse(input, dateTimeFormatter);
        }
        System.out.print(">>> Nhập mã phòng: ");
        maPhong = scanner.nextLine().trim();
        System.out.print(">>> Nhập đơn giá của phòng (đơn vị: đồng): ");
        input = scanner.nextLine().trim();
        try {
            donGia = Double.valueOf(input);
        } catch (NumberFormatException e) {
            donGia = 0.0;
        }
        System.out.print(">>> Nhập số lượng: ");
        input = scanner.nextLine().trim();
        try {
            soLuong = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            soLuong = 1;
        }
        if (loaiPhong.equals(HoaDonThuePhong.GIO)) {
            hoaDon = new HoaDonTheoGio(maHoaDon, ngay, tenHoaDon, maPhong, donGia, soLuong);
        } else {
            hoaDon = new HoaDonTheoNgay(maHoaDon, ngay, tenHoaDon, maPhong, donGia, soLuong);
        }
        list.add(hoaDon);

        // Xuất danh sách các hóa đơn thuê phòng.
        String headerLine = String.format("%-5s | %-15s | %15s | %-25s | %-15s | %20s | %10s | %10s",
                "STT", "Mã hoá đơn", "Ngày đăng kí", "Tên đăng kí", "Mã phòng", "Đơn giá", "Số lượng", "Đơn vị"
        );
        System.out.println("\n" + headerLine);
        String lineSymbol = "=";
        for (int i = 0; i < headerLine.length(); i++) {
            System.out.print(lineSymbol);
        }
        System.out.println();
        list.printList();

        // Tính tổng số lượng cho từng loại thuê phòng.
        System.out.println("\nSố lượng hoá đơn theo giờ: " + list.soLuongHoaDon(HoaDonThuePhong.GIO));
        System.out.println("Số lượng hoá đơn theo ngày: " + list.soLuongHoaDon(HoaDonThuePhong.NGAY));

        // Tính trung bình thành tiền của hóa đơn thuê phòng trong tháng 9/2023
        int nam = 2023;
        int thang = 9;
        System.out.printf("\nTrung bình thành tiền của hoá đơn thuê phòng trong %02d/%d: %s\n", thang, nam, list.trungBinhThanhTien(nam, thang));
    }
}
