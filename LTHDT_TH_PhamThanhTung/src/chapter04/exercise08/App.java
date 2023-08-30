/*
 *  @ (#)
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise08;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Chương trình giao dịch nhà đất
 * @author: tungpt
 * @version: 1.0
 * @since: August 30, 2023
 */
public class App {
    public static void main(String[] args) {
        // Nhập xuất danh sách các giao dịch
        GiaoDichNhaDat giaoDich1 = new GiaoDichDat("GDD001", LocalDate.of(2013,5,15), 2100000.0,
                GiaoDichDat.LOAI_A, 200.0);
        GiaoDichNhaDat giaoDich2 = new GiaoDichDat("GDD002", LocalDate.of(2013,9,15), 1500000.0,
                GiaoDichDat.LOAI_B, 300.0);
        GiaoDichNhaDat giaoDich3 = new GiaoDichDat("GDD003", LocalDate.of(2013,5,15), 1800000.0,
                GiaoDichDat.LOAI_C, 400.0);
        GiaoDichNhaDat giaoDich4 = new GiaoDichDat("GDD004", LocalDate.of(2013,9,15), 2000000.0,
                GiaoDichDat.LOAI_A, 180.0);
        GiaoDichNhaDat giaoDich5 = new GiaoDichDat("GDD005", LocalDate.of(2013,5,15), 2500000.0,
                GiaoDichDat.LOAI_C, 220.0);
        GiaoDichNhaDat giaoDich6 = new GiaoDichNha("GDD006", LocalDate.of(2013,5,15), 100000000.0,
                GiaoDichNha.LOAI_THUONG, 120.0, "Hồ Chí Minh");
        GiaoDichNhaDat giaoDich7 = new GiaoDichNha("GDD007", LocalDate.of(2013,9,15), 80000000.0,
                GiaoDichNha.LOAI_CAO_CAP, 180.0, "Long An");
        GiaoDichNhaDat giaoDich8 = new GiaoDichNha("GDD008", LocalDate.of(2013,9,15), 65000000.0,
                GiaoDichNha.LOAI_THUONG, 550.0, "Cà Mau");
        GiaoDichNhaDat giaoDich9 = new GiaoDichNha("GDD009", LocalDate.of(2013,5,15), 150000000.0,
                GiaoDichNha.LOAI_CAO_CAP, 100.0, "Hồ Chí Minh");

        List<GiaoDichNhaDat> giaoDichNhaDatList = new ArrayList<>();
        giaoDichNhaDatList.add(giaoDich1);
        giaoDichNhaDatList.add(giaoDich2);
        giaoDichNhaDatList.add(giaoDich3);
        giaoDichNhaDatList.add(giaoDich4);
        giaoDichNhaDatList.add(giaoDich5);
        giaoDichNhaDatList.add(giaoDich6);
        giaoDichNhaDatList.add(giaoDich7);
        giaoDichNhaDatList.add(giaoDich8);
        giaoDichNhaDatList.add(giaoDich9);

        System.out.println("Danh sách của tất cả các giao dịch");
        for (GiaoDichNhaDat giaoDich: giaoDichNhaDatList) {
            System.out.println(giaoDich);
        }

        // Tính tổng số lượng cho từng loại.
        int soLuongGiaoDichDat = 0;
        int soLuongGiaoDichNha = 0;
        double tongThanhTienGiaoDichDat = 0.0;
        for (GiaoDichNhaDat giaoDich: giaoDichNhaDatList) {
            if (giaoDich instanceof GiaoDichDat) {
                soLuongGiaoDichDat++;
                tongThanhTienGiaoDichDat += giaoDich.thanhTien();
            }
            if (giaoDich instanceof GiaoDichNha) {
                soLuongGiaoDichNha++;
            }
        }
        System.out.println("\nTổng số lượng của giao dịch đất: " + soLuongGiaoDichDat);
        System.out.println("Tổng số lượng của giao dịch đất: " + soLuongGiaoDichNha);

        // Tính trung bình thành tiền của giao dịch đất.
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        System.out.println("\nTrung bình thành tiền của giao dịch đất: "
                + decimalFormat.format(tongThanhTienGiaoDichDat/soLuongGiaoDichDat));

        // Xuất ra các giao dịch của tháng 9 năm 2013.
        System.out.println("\nCác giao dịch của tháng 9 năm 2013");
        LocalDate localDate = null;
        for (GiaoDichNhaDat giaoDich: giaoDichNhaDatList) {
            localDate = giaoDich.getNgayGiaoDich();
            if (localDate.getYear() == 2013 && localDate.getMonthValue() == 9) {
                System.out.println(giaoDich);
            }
        }
    }
}
