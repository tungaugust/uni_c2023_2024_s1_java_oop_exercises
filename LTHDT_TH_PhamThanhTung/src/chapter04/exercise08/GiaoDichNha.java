/*
 *  @ (#)
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise08;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 30, 2023
 */
public class GiaoDichNha extends GiaoDichNhaDat {
    public final static String LOAI_THUONG = "nhà thường";
    public final static String LOAI_CAO_CAP = "nhà cao cấp";
    private String diaChi;

    public GiaoDichNha() {
        super();
        this.diaChi = "chưa xác định";
    }

    public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, String loai, double dienTich, String diaChi) {
        super(maGiaoDich, ngayGiaoDich, donGia, loai, dienTich);
        setDiaChi(diaChi);
    }

    @Override
    public double thanhTien() {
        if (getLoai().equals(LOAI_THUONG)) {
            return getDonGia() * getDienTich() * 0.9;
        }
        if (getLoai().equals(LOAI_CAO_CAP)) {
            return getDonGia() * getDienTich();
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", super.toString(), diaChi);
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
