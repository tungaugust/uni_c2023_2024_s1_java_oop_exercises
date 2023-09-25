/*
 *  @ (#) HangHoa.java      1.0 20/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise11;

import java.text.DecimalFormat;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 20, 2023
 */
public abstract class HangHoa {
    private String maHang;
    private String tenHang;
    private int soLuong;
    private double donGia;
    private double VAT;

    public HangHoa(String maHang, String tenHang, int soLuong, double donGia, double VAT) {
        setMaHang(maHang);
        setTenHang(tenHang);
        setSoLuong(soLuong);
        setDonGia(donGia);
        setVAT(VAT);
    }

    private void setVAT(double VAT) {
        this.VAT = VAT;
    }

    public double getVAT() {
        return VAT;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    private void setMaHang(String maHang) {
        if (maHang == null) {
            throw new IllegalArgumentException("Mã hàng hoá không được để trống");
        }
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang.equals("")) {
            throw new IllegalArgumentException("Tên hàng hoá không được rỗng");
        }
        this.tenHang = tenHang;
    }

    public void setSoLuong(int soLuong) {
        if (soLuong < 0) {
            soLuong = 0;
        }
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        if (donGia <= 0) {
            throw new IllegalArgumentException("Đơn giá hàng hoá phải lớn hơn 0");
        }
        this.donGia = donGia;
    }

    public abstract String danhGia();

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00 VND");
        return "maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + decimalFormat.format(donGia) +
                ", VAT=" + String.format("%.1f%%", VAT*100);
    }
}
