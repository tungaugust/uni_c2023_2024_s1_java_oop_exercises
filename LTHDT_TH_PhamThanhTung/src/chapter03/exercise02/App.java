/*
 *  @ (#) App.java      1.0 23/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise02;

import java.util.Scanner;

/**
 * Chương trình quản lý sinh viên
 * @author: tungpt
 * @version: 1.0
 * @since: August 23, 2023
 */
public class App {
    public static void main(String[] args) {
        SinhVien sinhVien1 = new SinhVien(1100, "Phạm Thanh Tùng", 9.0f, 9.5f);
        SinhVien sinhVien2 = new SinhVien(1101, "Phạm Thanh Phong", 9.5f, 9.0f);
        SinhVien sinhVien3 = new SinhVien();

        System.out.println("Nhập thông tin cho sinhVien3:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("+ Nhập mã sinh viên: ");
        int maSinhVien = Integer.valueOf(scanner.nextLine().trim());
        System.out.print("+ Nhập họ và tên: ");
        String hoTen = String.valueOf(scanner.nextLine().trim());
        System.out.print("+ Nhập điểm lý thuyết: ");
        float diemLT = Float.valueOf(scanner.nextLine().trim());
        System.out.print("+ Nhập điểm thực hành: ");
        float diemTH = Float.valueOf(scanner.nextLine().trim());

        sinhVien3.setMaSinhVien(maSinhVien);
        sinhVien3.setHoTen(hoTen);
        sinhVien3.setDiemLT(diemLT);
        sinhVien3.setDiemTH(diemTH);

        String headerLine = String.format("%-6s | %-30s | %10s | %10s | %10s",
                "MSSV", "Họ và tên", "Điểm LT", "Điểm TH", "Điểm TB"
        );
        System.out.println(headerLine);
        String lineSymbol = "=";
        for (int i = 0; i < headerLine.length(); i++) {
            System.out.print(lineSymbol);
        }
        System.out.println();

        System.out.println(sinhVien1);
        System.out.println(sinhVien2);
        System.out.println(sinhVien3);
    }
}
