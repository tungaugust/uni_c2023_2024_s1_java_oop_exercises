/*
 *  @ (#) HangThucPham.java      1.0 24/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise03b;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 24, 2023
 */
public class HangThucPham {
    private String maHang;
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;

    public String getMaHang() {
        return maHang;
    }

    private void setMaHang(String maHang) {
        if (maHang.equals("") || maHang == null) {
            throw new RuntimeException("Mã hàng không được đễ rỗng.");
        }
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (maHang.equals("")) {
            throw new RuntimeException("Tên hàng không được đễ rỗng.");
        }
        this.tenHang = tenHang;
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

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (ngaySanXuat == null) {
            throw new RuntimeException("Ngày không được đễ rỗng.");
        }
        if (ngaySanXuat.isAfter(LocalDate.now())) {
            ngaySanXuat = LocalDate.now();
        }
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (ngayHetHan == null) {
            throw new RuntimeException("Ngày không được đễ rỗng.");
        }
        if (ngayHetHan.isBefore(getNgaySanXuat())) {
            ngayHetHan = getNgaySanXuat();
        }
        this.ngayHetHan = ngayHetHan;
    }

    /**
     * Default constructor của lớp HangThucPham
     * @param maHang: mã hàng không được phép sửa, không được để trống, không phải là chuỗi rỗng
     */
    public HangThucPham(String maHang) {
        setMaHang("Unidentified Code!");
        setTenHang("Unidentified Name!");
        setDonGia(0.0);
        setNgaySanXuat(LocalDate.now());
        setNgayHetHan(LocalDate.now());
    }

    /**
     * Constructor của lớp HangThucPham
     * @param maHang: mã hàng không được phép sửa, không được để trống, không phải là chuỗi rỗng
     * @param tenHang: tên hàng không được để trống, không phải là chuỗi rỗng
     * @param donGia: đơn giá không được là số âm
     * @param ngaySanXuat: ngày sản xuất không được để trống
     * @param ngayHetHan: ngày hết hạn không được để trống, và phải sau (hoặc cùng) ngày sản xuất
     */
    public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        setMaHang(maHang);
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    @Override
    public String toString() {
        // Định dạng ngày
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-15s | %-20s | %,25.3f | %20s | %20s",
                getMaHang(),
                getTenHang(),
                getDonGia(),
                getNgaySanXuat().format(dateTimeFormatter),
                getNgayHetHan().format(dateTimeFormatter)
        );
    }
}
