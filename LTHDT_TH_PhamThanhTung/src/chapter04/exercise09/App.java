/*
 *  @ (#)
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise09;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Chương trình quản lý danh sách hoá đơn tiền điện của khách hàng
 * @author: tungpt
 * @version: 1.0
 * @since: August 30, 2023
 */
public class App {
    public static void main(String[] args) {
        // Nhập xuất danh sách các giao dịch
        KhachHang khachHang1 = new KhachHangVietNam("KHVN001", "Lê Quang Nhân", LocalDate.of(2013,9,10),
                KhachHangVietNam.KINH_DOANH, 3000.0, 200, 150);
        KhachHang khachHang2 = new KhachHangVietNam("KHVN002", "Trần Trọng Nghĩa", LocalDate.of(2013,9,11),
                KhachHangVietNam.SAN_XUAT, 3000.0, 500, 300);
        KhachHang khachHang3 = new KhachHangVietNam("KHVN003", "Lý Hoàng Lễ", LocalDate.of(2013,8,15),
                KhachHangVietNam.KINH_DOANH, 3000.0, 140, 150);
        KhachHang khachHang4 = new KhachHangVietNam("KHVN004", "Đinh Minh Trí", LocalDate.of(2013,9,10),
                KhachHangVietNam.SINH_HOAT, 3000.0, 85, 100);
        KhachHang khachHang5 = new KhachHangNuocNgoai("KHNN001", "John Smith", LocalDate.of(2013,9,10),
                "Anh", 5000.0, 111);
        KhachHang khachHang6 = new KhachHangNuocNgoai("KHNN002", "Peter Walker", LocalDate.of(2013,10,12),
                "Úc", 5000.0, 102);
        KhachHang khachHang7 = new KhachHangNuocNgoai("KHNN003", "Cassandra Sirius", LocalDate.of(2013,9,10),
                "Pháp", 5000.0, 95);
        KhachHang khachHang8 = new KhachHangNuocNgoai("KHNN004", "Joseph Valentine", LocalDate.of(2013,9,10),
                "Ý", 5000.0, 110);

        List<KhachHang> khachHangList = new ArrayList<>();
        khachHangList.add(khachHang1);
        khachHangList.add(khachHang2);
        khachHangList.add(khachHang3);
        khachHangList.add(khachHang4);
        khachHangList.add(khachHang5);
        khachHangList.add(khachHang6);
        khachHangList.add(khachHang7);
        khachHangList.add(khachHang8);

        System.out.println("Danh sách của tất cả các hoá đơn khách hàng");
        String headerLine = String.format("%-5s | %-10s | %-25s | %15s | %15s | %15s | %10s",
                "STT", "Mã KH", "Tên KH", "Ngày xuất", "Loại/Quốc tịch", "Đơn giá (VND)", "Số KW"
        );
        String lineSymbol = "=";
        System.out.println(headerLine);
        for (int i = 0; i < headerLine.length(); i++) {
            System.out.print(lineSymbol);
        }
        System.out.println();
        for (int i = 0; i < khachHangList.size(); i++) {
            System.out.printf("%-5s | %s\n", i + 1, khachHangList.get(i));
        }

        // Tính tổng số lượng cho từng loại khách hàng
        int soLuongKHVN = 0;
        int soLuongKHNN = 0;
        double tongTienHDKHNN = 0.0;
        for (KhachHang khachHang: khachHangList){
            if (khachHang instanceof KhachHangVietNam) {
                soLuongKHVN++;
            }
            if (khachHang instanceof KhachHangNuocNgoai) {
                soLuongKHNN++;
                tongTienHDKHNN += khachHang.thanhTien();
            }
        }

        // Tính trung bình thành tiền của khách hàng người nước ngoài
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        System.out.println("\nTrung bình thành tiền của khách hàng người nước ngoài: "
                + decimalFormat.format(tongTienHDKHNN/soLuongKHNN));

        // Xuất ra các hoá đơn trong tháng 09 năm 2013 (cùa cả 2 loại khách hàng)
        System.out.println("\nCác hoá đơn trong tháng 9 năm 2013");
        LocalDate localDate = null;
        int index = 1;
        for (int i = 0; i < khachHangList.size(); i++) {
            localDate = khachHangList.get(i).getNgayXuat();
            if (localDate.getYear() == 2013 && localDate.getMonthValue() == 9) {
                System.out.printf("%-5s | %s\n", index, khachHangList.get(i));
                index++;
            }
        }

    }
}
