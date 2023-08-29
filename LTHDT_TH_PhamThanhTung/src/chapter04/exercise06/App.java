/*
 *  @ (#) App.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise06;

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
        // Nhập danh sách các loại sách
        Sach sach1 = new SachGiaoKhoa("GT12", LocalDate.of(2020,1,1), 10000.0, 10, "NXB GDVN", SachGiaoKhoa.NEW);
        Sach sach2 = new SachGiaoKhoa("HH12", LocalDate.of(2017,1,1), 6000.0, 10, "NXB GDVN", SachGiaoKhoa.OLD);
        Sach sach3 = new SachGiaoKhoa("CN12", LocalDate.of(2017,1,1), 10000.0, 10, "NXB Trẻ", SachGiaoKhoa.OLD);
        Sach sach4 = new SachGiaoKhoa("VL12", LocalDate.of(2020,1,1), 17000.0, 10, "NXB GDVN", SachGiaoKhoa.NEW);
        Sach sach5 = new SachGiaoKhoa("SH12", LocalDate.of(2017,1,1), 18000.0, 10, "NXB Trẻ", SachGiaoKhoa.OLD);
        Sach sach6 = new SachThamKhao("HHHC", LocalDate.of(2016,6,16), 50000.0, 10, "NXB ĐHQG HN", 10000.0);
        Sach sach7 = new SachThamKhao("HHVC", LocalDate.of(2017,6,16), 50000.0, 10, "NXB ĐHQG HN", 10000.0);
        Sach sach8 = new SachThamKhao("VANTNTHPT", LocalDate.of(2023,1,1), 54000.0, 10, "NXB Trẻ", 12000.0);
        Sach sach9 = new SachThamKhao("TOANCOMBO", LocalDate.of(2022,1,1), 116000.0, 10, "NXB Dân Trí", 30000.0);

        List<Sach> sachList = new ArrayList<>();
        sachList.add(sach1);
        sachList.add(sach2);
        sachList.add(sach3);
        sachList.add(sach4);
        sachList.add(sach5);
        sachList.add(sach6);
        sachList.add(sach7);
        sachList.add(sach8);
        sachList.add(sach9);

        // Xuất danh sách các loại sách
        System.out.println("Danh sách của thư viện:");
        double tongThanhTienSachGiaoKhoa = 0.0;
        double tongThanhTienSachThamKhao = 0.0;
        double tongDonGiaSachThamKhao = 0.0;
        int soSachThamKhao = 0;
        for (Sach sach: sachList) {
            System.out.println(sach);
            if (sach instanceof SachGiaoKhoa){
                tongThanhTienSachGiaoKhoa += sach.thanhTien();
            }
            if (sach instanceof SachThamKhao){
                tongThanhTienSachThamKhao += sach.thanhTien();
                tongDonGiaSachThamKhao += sach.getDonGia();
                soSachThamKhao++;
            }
        }

        // Tính tổng thành tiền cho từng loại
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VND");
        System.out.println("\nTổng thành tiền của sách giáo khoa: " + decimalFormat.format(tongThanhTienSachGiaoKhoa));
        System.out.println("Tổng thành tiền của sách tham khảo: " + decimalFormat.format(tongThanhTienSachThamKhao));

        // Tính trung bình cộng đơn giá của các sách tham khảo
        System.out.println("\nTrung bình công đơn giá của sách giáo khoa: " + decimalFormat.format(tongDonGiaSachThamKhao / soSachThamKhao));

        // Xuất ra các sách giáo khoa của nhà xuất bản X, ví dụ: NXB Trẻ
        String nxb = "NXB Trẻ";
        System.out.println("\nDanh sách của sách giao khoa của " + nxb + ":");
        for (Sach sach: sachList) {
            if (sach.getNhaXuatBan().toLowerCase().equals(nxb.toLowerCase())
                    && (sach instanceof SachGiaoKhoa)){
                System.out.println(sach);
            }
        }
    }
}
