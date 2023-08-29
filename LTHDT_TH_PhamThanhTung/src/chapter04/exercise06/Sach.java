/*
 *  @ (#) Sach.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise06;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public abstract class Sach {
    private String maSach;
    private LocalDate ngayNhap;
    private double donGia;
    private int soLuong;
    private String nhaXuatBan;

    public Sach() {
        this.maSach = "No code";
        this.ngayNhap = LocalDate.now();
        this.donGia = 0.0;
        this.soLuong = 0;
        this.nhaXuatBan = "No name";
    }

    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        setMaSach(maSach);
        setNgayNhap(ngayNhap);
        setDonGia(donGia);
        setSoLuong(soLuong);
        setNhaXuatBan(nhaXuatBan);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s | %s | %s | %d | %s | %s",
                maSach,
                ngayNhap.format(dateTimeFormatter),
                decimalFormat.format(donGia),
                soLuong,
                nhaXuatBan,
                decimalFormat.format(thanhTien())
        );
    }

    public abstract double thanhTien();

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }
}
