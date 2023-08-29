/*
 *  @ (#) GiaoDichTienTe.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise07;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class GiaoDichTienTe extends GiaoDich {
    private double tiGia;   // tỉ giá so với VND
    public final static String EUR = "đồng Euro";
    public final static String USD = "đồng dollar Mỹ";
    public final static String VND = "đồng Việt Nam";

    public GiaoDichTienTe(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loai, double tiGia) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong, loai);
        setTiGia(tiGia);
    }

    @Override
    public double thanhTien() {
        double rate = getLoai().equals(VND) ? 1.0 : getTiGia();
        return getDonGia() * getSoLuong() * rate;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", super.toString(), tiGia);
    }

    public double getTiGia() {
        return tiGia;
    }

    private void setTiGia(double tiGia) {
        this.tiGia = tiGia;
    }
}
