/*
 *  @ (#) App.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise07;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class App {
    public static void main(String[] args) {
        // Nhập xuất danh sách các giao dịch
        GiaoDich giaoDich1 = new GiaoDichVang("GDV001", LocalDate.of(2023, 8, 29), 67520000.0, 10, "Vàng miếng");
        GiaoDich giaoDich2 = new GiaoDichVang("GDV002", LocalDate.of(2023, 8, 29), 55900000.0, 20, "Vàng 24K");
        GiaoDich giaoDich3 = new GiaoDichVang("GDV003", LocalDate.of(2023, 8, 29), 41280000.0, 35, "Vàng 18K");
        GiaoDich giaoDich4 = new GiaoDichVang("GDV004", LocalDate.of(2023, 8, 29), 17460000.0, 25, "Vàng 8K");

        GiaoDich giaoDich5 = new GiaoDichTienTe("GDT001", LocalDate.of(2023, 8, 29), 10000000.0, 15, GiaoDichTienTe.VND, 1.0);
        GiaoDich giaoDich6 = new GiaoDichTienTe("GDT002", LocalDate.of(2023, 8, 29), 2000.0, 25, GiaoDichTienTe.USD, 24190.0);
        GiaoDich giaoDich7 = new GiaoDichTienTe("GDT003", LocalDate.of(2023, 8, 29), 1200.0, 20, GiaoDichTienTe.EUR, 26289.04);

        List<GiaoDich> giaoDichList = new ArrayList<>();
        giaoDichList.add(giaoDich1);
        giaoDichList.add(giaoDich2);
        giaoDichList.add(giaoDich3);
        giaoDichList.add(giaoDich4);
        giaoDichList.add(giaoDich5);
        giaoDichList.add(giaoDich6);
        giaoDichList.add(giaoDich7);

        int tongSoLuongGiaoDichVang = 0;
        int tongSoLuongGiaoDichTienTe = 0;
        double tongThanhTienGiaoDichTienTe = 0.0;
        System.out.println("Danh sách các giao dịch");
        for (GiaoDich giaoDich: giaoDichList) {
            if (giaoDich instanceof GiaoDichVang) {
                tongSoLuongGiaoDichVang++;
            }
            if (giaoDich instanceof GiaoDichTienTe) {
                tongThanhTienGiaoDichTienTe += giaoDich.thanhTien();
                tongSoLuongGiaoDichTienTe++;
            }
            System.out.println(giaoDich);
        }

        // Tính tổng số lượng cho từng loại
        System.out.println("\nTổng số lượng giao dịch vàng: " + tongSoLuongGiaoDichVang);
        System.out.println("Tổng số lượng giao dịch tiền tệ: " + tongSoLuongGiaoDichTienTe);

        // Tính trung bình thành tiền của giao dịch tiền tệ
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        System.out.println("\nTrung bình thành tiền của các giao dịch tiền tệ: "
                + decimalFormat.format(tongThanhTienGiaoDichTienTe / tongSoLuongGiaoDichTienTe));

        // Xuất ra các giao dịch có đơn giá > 1 tỷ
        System.out.println("\nCác giao dịch có đơn giá > 1 tỷ");
        for (GiaoDich giaoDich: giaoDichList) {
            if (giaoDich.thanhTien() > 1000000000.0) {
                System.out.println(giaoDich);
            }
        }
    }
}
