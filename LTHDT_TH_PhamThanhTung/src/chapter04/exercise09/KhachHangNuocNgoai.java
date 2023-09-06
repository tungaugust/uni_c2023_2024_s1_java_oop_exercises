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
public class KhachHangNuocNgoai extends KhachHang{

    public KhachHangNuocNgoai() {
        super();
    }

    public KhachHangNuocNgoai(String maKH, String hoTen, LocalDate ngayXuat, String loai, double donGia, int soLuong) {
        super(maKH, hoTen, ngayXuat, loai, donGia, soLuong);
    }

    @Override
    public double thanhTien() {
        return getDonGia() * getSoLuong();
    }

}
