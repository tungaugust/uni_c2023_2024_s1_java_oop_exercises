/*
 *  @ (#)
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise09;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 30, 2023
 */
public abstract class KhachHang {
    private String maKH;
    private String hoTen;
    private LocalDate ngayXuat; // ngày xuất hoá đơn
    private String loai;    // loại khách hàng với khách hàng Việt Nam, quốc tic đối với khách hàng nước ngoài
    private double donGia;
    private int soLuong;    // số KW tiêu thụ

    public KhachHang() {
        this.maKH = "chưa xác định";
        this.hoTen = "chưa xác định";
        this.ngayXuat = LocalDate.now();
        this.loai = "chưa xác định";
        this.donGia = 0.0;
        this.soLuong = 0;
    }

    public KhachHang(String maKH, String hoTen, LocalDate ngayXuat, String loai, double donGia, int soLuong) {
        setMaKH(maKH);
        setHoTen(hoTen);
        setNgayXuat(ngayXuat);
        setLoai(loai);
        setDonGia(donGia);
        setSoLuong(soLuong);
    }

    public abstract double thanhTien();

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(LocalDate ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
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
}
