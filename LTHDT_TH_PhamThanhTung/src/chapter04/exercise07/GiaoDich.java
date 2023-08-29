/*
 *  @ (#) GiaoDich.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise07;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public abstract class GiaoDich {
    private String maGiaoDich;  // mã giao dịch
    private LocalDate ngayGiaoDich; // ngày giao dịch
    private double donGia;  // đơn giá từng giao dịch
    private int soLuong;    // số lượng giao dịch
    private String loai;    // loại (vàng, tiền tệ: VN, USD, EUR)

    public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loai) {
        setMaGiaoDich(maGiaoDich);
        setNgayGiaoDich(ngayGiaoDich);
        setDonGia(donGia);
        setSoLuong(soLuong);
        setLoai(loai);
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s | %s | %s | %d | %s",
                maGiaoDich,
                ngayGiaoDich.format(dateTimeFormatter),
                decimalFormat.format(donGia),
                soLuong,
                loai);
    }

    public String getLoai() {
        return loai;
    }

    private void setLoai(String loai) {
        this.loai = loai;
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    private void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    private void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    private void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    private void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
