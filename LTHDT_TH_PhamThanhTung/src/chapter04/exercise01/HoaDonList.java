/*
 *  @ (#) HoaDonList.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise01;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public class HoaDonList {
    private HoaDonThuePhong[] hoaDonlist;
    private int count;

    public HoaDonList() {
        this.hoaDonlist = new HoaDonThuePhong[10];
        this.count = 0;
    }

    public HoaDonList(int n) {
        if (n > 0) {
            this.hoaDonlist = new HoaDonThuePhong[n];
        } else {
            this.hoaDonlist = new HoaDonThuePhong[10];
        }
        this.count = 0;
    }

    public boolean add(HoaDonThuePhong hoaDon) {
        if (this.count < this.hoaDonlist.length) {
            this.hoaDonlist[this.count] = hoaDon;
            this.count++;
            return true;
        }
        return false;
    }

    public int soLuongHoaDon(String loaiHoaDon){
        int count = 0;
        if (loaiHoaDon.equals(HoaDonThuePhong.GIO)) {
            for (int i = 0; i < this.count; i++) {
                if (this.hoaDonlist[i] instanceof HoaDonTheoGio){
                    count++;
                }
            }
        }
        if (loaiHoaDon.equals(HoaDonThuePhong.NGAY)) {
            for (int i = 0; i < this.count; i++) {
                if (this.hoaDonlist[i] instanceof HoaDonTheoNgay){
                    count++;
                }
            }
        }
        return count;
    }

    public void printList() {
        String donVi;
        for (int i = 0; i < this.count; i++) {
            donVi = (this.hoaDonlist[i] instanceof HoaDonTheoGio) ? "giờ" : "ngày";
            System.out.printf("%-5d | %s | %10s\n", i+1, this.hoaDonlist[i], donVi);
        }
    }

    public String trungBinhThanhTien(int year, int month) {
        Locale locale = new Locale("vi", "vn");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        if (this.count == 0) {
            return numberFormat.format(0.0);
        }
        double sum = 0.0;
        int count = 0;
        LocalDate date;
        for (int i = 0; i < this.count; i++) {
            date = this.hoaDonlist[i].getNgayHoaDon();
            if (date.getYear() == year
                    && date.getMonth().getValue() == month) {
                sum += this.hoaDonlist[i].thanhTien();
                count++;
            }
        }
        return numberFormat.format(sum/count);
    }
}
