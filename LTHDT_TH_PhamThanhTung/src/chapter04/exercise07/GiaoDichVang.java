/*
 *  @ (#) GiaoDichVang.java      1.0 29/08/2023
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
public class GiaoDichVang extends GiaoDich{
    public GiaoDichVang(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loai) {
        super(maGiaoDich, ngayGiaoDich, donGia, soLuong, loai);
        // loại vàng: Vàng 9999, 24K (vàng 999), 18K 14K 10K (vàng trắng, vàng hồng), ...
    }

    @Override
    public double thanhTien() {
        return getSoLuong() * getDonGia();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
