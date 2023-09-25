/*
 *  @ (#) HangSanhSu.java      1.0 20/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise11;

import com.sun.org.apache.bcel.internal.generic.LCONST;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 20, 2023
 */
public class HangSanhSu extends HangHoa{
    private LocalDate ngaySanXuat;
    private LocalDate ngayNhapKho;

    public HangSanhSu(String maHang, String tenHang, int soLuong, double donGia, LocalDate ngaySanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, soLuong, donGia, 0.1);
        setNgaySanXuat(ngaySanXuat);
        setNgayNhapKho(ngayNhapKho);
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (ngaySanXuat.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày sản xuất phải trước hoặc cùng ngày hiện tại");
        }
        this.ngaySanXuat = ngaySanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(LocalDate ngayNhapKho) {
        if (ngayNhapKho.isBefore(this.ngaySanXuat) || ngayNhapKho.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày nhập kho phải sau hoặc cùng ngày sản xuất và trước hoặc cùng ngày hiện tại");
        }
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String danhGia() {
        String danhGia = null;
        if (getSoLuong() > 50 && this.ngayNhapKho.plusDays(10).isAfter(LocalDate.now())){
            danhGia = "bán chậm";
        }
        return danhGia;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "HangSanhSu [" +
                super.toString() +
                ", ngaySanXuat=" + ngaySanXuat.format(dateTimeFormatter) +
                ", ngayNhapKho=" + ngayNhapKho.format(dateTimeFormatter) +
                ']';
    }
}
