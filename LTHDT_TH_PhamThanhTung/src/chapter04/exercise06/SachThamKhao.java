/*
 *  @ (#) SachThamKhao.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise06;

import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class SachThamKhao extends Sach{
    private double thue;

    public SachThamKhao() {
        super();
        this.thue = 0.0;
    }

    @Override
    public double thanhTien() {
        return getDonGia() * getSoLuong() + getThue();
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return String.format("%s | %s", super.toString(), decimalFormat.format(thue));
    }

    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        setThue(thue);
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }
}
