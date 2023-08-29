/*
 *  @ (#) SachGiaoKhoa.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise06;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class SachGiaoKhoa extends Sach{
    public final static String NEW = "mới";
    public final static String OLD = "cũ";
    private String tinhTrang;

    public SachGiaoKhoa() {
        super();
        this.tinhTrang = OLD;
    }

    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        setTinhTrang(tinhTrang);
    }

    @Override
    public double thanhTien() {
        double rate = getTinhTrang().equals(NEW) ? 1.0 : 0.5;
        return getDonGia() * getSoLuong() * rate;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", super.toString(), tinhTrang);
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        if (tinhTrang.equals("")) {
            tinhTrang = OLD;
        }
        this.tinhTrang = tinhTrang;
    }
}
