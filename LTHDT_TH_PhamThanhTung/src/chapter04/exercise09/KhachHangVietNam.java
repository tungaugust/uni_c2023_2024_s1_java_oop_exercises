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
public class KhachHangVietNam extends KhachHang {
    public static final String SINH_HOAT = "sinh hoạt";
    public static final String KINH_DOANH = "kinh doanh";
    public static final String SAN_XUAT = "sản xuất";

    private int dinhMuc;    // định mức tiêu thụ

    public KhachHangVietNam() {
        super();
        this.dinhMuc = 0;
    }

    public KhachHangVietNam(String maKH, String hoTen, LocalDate ngayXuat, String loai, double donGia, int soLuong, int dinhMuc) {
        super(maKH, hoTen, ngayXuat, loai, donGia, soLuong);
        setDinhMuc(dinhMuc);
    }

    @Override
    public double thanhTien() {
        if (getSoLuong() <= dinhMuc) {
            return getSoLuong() * getDonGia();
        }
        return getDonGia() * (dinhMuc + (getSoLuong() - dinhMuc)*2.5);
    }

    public int getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(int dinhMuc) {
        this.dinhMuc = dinhMuc;
    }
}
