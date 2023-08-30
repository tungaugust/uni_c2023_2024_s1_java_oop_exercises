/*
 *  @ (#)
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise08;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 30, 2023
 */
public abstract class GiaoDichNhaDat {
    private String maGiaoDich;
    private LocalDate ngayGiaoDich;
    private double donGia;
    private String loai;
    private double dienTich;

    public GiaoDichNhaDat() {
        this.maGiaoDich = "chưa xác định";
        this.ngayGiaoDich = LocalDate.now();
        this.donGia = 0.0;
        this.loai = "chưa xác định";
        this.dienTich = 0.0;
    }

    public GiaoDichNhaDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, String loai, double dienTich) {
        setMaGiaoDich(maGiaoDich);
        setNgayGiaoDich(ngayGiaoDich);
        setDonGia(donGia);
        setLoai(loai);
        setDienTich(dienTich);
    }

    public abstract double thanhTien();

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return String.format("%s | %s | %s | %s | %.2f",
                maGiaoDich,
                ngayGiaoDich.format(dateTimeFormatter),
                decimalFormat.format(donGia),
                loai,
                dienTich);
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        if (maGiaoDich.equals("")) {
            throw new IllegalArgumentException("Mã giao dịch không được rỗng");
        }
        this.maGiaoDich = maGiaoDich;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        if (ngayGiaoDich == null) {
            throw new IllegalArgumentException("Ngày giao dịch không được trống");
        }
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia < 0) {
            donGia = 0.0;
        }
        this.donGia = donGia;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        if (loai.equals("")) {
            throw new IllegalArgumentException("Loại giao dịch không được rỗng");
        }
        this.loai = loai;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        if (dienTich < 0) {
            dienTich = 0.0;
        }
        this.dienTich = dienTich;
    }
}
