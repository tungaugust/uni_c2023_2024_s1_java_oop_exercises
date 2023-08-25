/*
 *  @ (#) HoaDonTheoGio.java      1.0 25/08/2023
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
public class HoaDonTheoGio extends HoaDonThuePhong {
    private int soGioThue;

    public int getSoGioThue() {
        return soGioThue;
    }

    public void setSoGioThue(int soGioThue) {
        if (soGioThue > 24 && soGioThue < 30) {
            soGioThue = 24;
        }
        if (soGioThue >= 30) {
            throw new UncheckedException(soGioThue);
        }
        this.soGioThue = soGioThue;
    }

    public HoaDonTheoGio() {
        super();
        this.soGioThue = 0;
    }

    public HoaDonTheoGio(int soGioThue){
        super();
        setSoGioThue(soGioThue);
    }

    public HoaDonTheoGio(String maHoaDon, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia, int soGioThue){
        super(maHoaDon, ngayHoaDon, tenKhachHang, maPhong, donGia);
        setSoGioThue(soGioThue);
    }

    @Override
    public double thanhTien() {
        return getDonGia() * getSoGioThue();
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
                getSoGioThue()
        );
    }
}
