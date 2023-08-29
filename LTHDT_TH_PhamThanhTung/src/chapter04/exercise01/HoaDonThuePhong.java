/*
 *  @ (#) HoaDonThuePhong.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise01;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public abstract class HoaDonThuePhong {
    private String maHoaDon;
    private LocalDate ngayHoaDon;
    private String tenKhachHang;
    private String maPhong;
    private double donGia;

    private final static String MA_HOA_DON = "chưa xác định";
    private final static String MA_PHONG = "chưa xác định";
    private final static String TEN_KHACH_HANG = "chưa xác định";

    public final static String GIO = "phòng theo giờ";
    public final static String NGAY = "phòng theo ngày";

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        if (maHoaDon.equals("") || maHoaDon == null) {
            maHoaDon = MA_HOA_DON;
        }
        this.maHoaDon = maHoaDon;
    }

    public LocalDate getNgayHoaDon() {
        return ngayHoaDon;
    }

    public void setNgayHoaDon(LocalDate ngayHoaDon) {
        if (ngayHoaDon == null){
            ngayHoaDon = LocalDate.now();
        }
        this.ngayHoaDon = ngayHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        if (tenKhachHang.equals("") || tenKhachHang == null) {
            tenKhachHang = TEN_KHACH_HANG;
        }
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        if (maPhong.equals("") || maPhong == null) {
            maPhong = MA_PHONG;
        }
        this.maPhong = maPhong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia < 0){
            donGia = 0.0;
        }
        this.donGia = donGia;
    }

    public HoaDonThuePhong(){
        setMaHoaDon(MA_HOA_DON);
        setNgayHoaDon(LocalDate.now());
        setTenKhachHang(TEN_KHACH_HANG);
        setMaPhong(MA_PHONG);
        setDonGia(0.0);
    }
    public HoaDonThuePhong(String maHoaDon, LocalDate ngayHoaDon, String tenKhachHang, String maPhong, double donGia) {
        setMaHoaDon(maHoaDon);
        setNgayHoaDon(ngayHoaDon);
        setTenKhachHang(tenKhachHang);
        setMaPhong(maPhong);
        setDonGia(donGia);
    }

    public abstract double thanhTien();
}
