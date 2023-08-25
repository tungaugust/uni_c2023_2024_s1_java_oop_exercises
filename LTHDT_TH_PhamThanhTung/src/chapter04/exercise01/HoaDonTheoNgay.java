/*
 *  @ (#) HoaDonTheoNgay.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise01;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public class HoaDonTheoNgay extends HoaDonThuePhong{
    private int soNgayThue;

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public HoaDonTheoNgay() {
        super();
        this.soNgayThue = 0;
    }

    public HoaDonTheoNgay(int soNgayThue) {
        super();
        setSoNgayThue(soNgayThue);
    }

    public HoaDonTheoNgay(String maHoaDon, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, int soNgayThue) {
        super(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia);
        this.soNgayThue = soNgayThue;
    }

    @Override
    public double thanhTien() {
        if (getSoNgayThue() > 7) {
            return getDonGia()*(7 + (getSoNgayThue() - 7)*0.8);
        }
        return getDonGia() * getSoNgayThue();
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale locale = new Locale("vi", "vn");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return String.format("%-15s | %15s | %-25s | %-15s | %20s | %10d",
                getMaHoaDon(),
                getNgayHoaDon().format(dateTimeFormatter),
                getTenKhachHang(),
                getMaPhong(),
                numberFormat.format(getDonGia()),
                getSoNgayThue()
        );
    }
}
