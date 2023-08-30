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
    private int dinhMuc;    // định mức tiêu thụ

    public KhachHangVietNam() {
        this.dinhMuc = 0;
    }

    public KhachHangVietNam(String maKH, String hoTen, LocalDate ngayXuat, String loai, double donGia, int soLuong, int dinhMuc) {
        super(maKH, hoTen, ngayXuat, loai, donGia, soLuong);
        setDinhMuc(dinhMuc);
    }

    @Override
    public double thanhTien() {
        return 0;
    }

    public int getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(int dinhMuc) {
        this.dinhMuc = dinhMuc;
    }
}
