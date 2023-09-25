/*
 *  @ (#) HangThucPham.java      1.0 20/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Deque;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 20, 2023
 */
public class HangThucPham extends HangHoa{
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private String nhaCungCap;

    public HangThucPham(String maHang, String tenHang, int soLuong, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuong, donGia, 0.05);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
        setNhaCungCap(nhaCungCap);
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan.isBefore(this.ngaySanXuat)) {
            ngayHetHan = this.ngaySanXuat;
        }
        this.ngayHetHan = ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public String danhGia() {
        String danhGia = null;
        if (getSoLuong() > 0 && this.ngayHetHan.isAfter(LocalDate.now())){
            danhGia = "khó bán";
        }
        return danhGia;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "HangThucPham [" +
                super.toString() +
                ", ngaySanXuat=" + ngaySanXuat.format(dateTimeFormatter) +
                ", ngayHetHan=" + ngayHetHan.format(dateTimeFormatter) +
                ", nhaCungCap='" + nhaCungCap + '\'' +
                ']';
    }
}
