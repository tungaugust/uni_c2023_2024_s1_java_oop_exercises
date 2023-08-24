/*
 *  @ (#) Account.java      1.0 24/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Lớp tài khoản
 * @author: tungpt
 * @version: 1.0
 * @since: August 24, 2023
 */
public class Account {
    private long soTaiKhoan;
    private String tenTaiKhoan;
    private double soTien;
    private String trangThai;

    private static final String TENTK_CHUA_XAC_DINH = "chưa xác định";
    private static final String SOTIEN_KHONG_HOP_LE = "số dư không đủ";
    private static final String SOTK_KHONG_HOP_LE = "chưa xác định";
    private static final long SOTK_MAC_DINH = 999999l;
    private static final double SOTIEN_MAC_DINH = 50.0;

    public long getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(long soTaiKhoan) {
        if (soTaiKhoan <= 0 || soTaiKhoan == SOTK_MAC_DINH){
            soTaiKhoan = SOTK_MAC_DINH;
            setTrangThai(SOTK_KHONG_HOP_LE);
        }
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        if (tenTaiKhoan.equals("")){
            tenTaiKhoan = TENTK_CHUA_XAC_DINH;
            setTrangThai(TENTK_CHUA_XAC_DINH);
        }
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public double getSoTien() {
        return soTien;
    }

    private void setSoTien(double soTien) {
        if (soTien < SOTIEN_MAC_DINH) {
            setTrangThai(SOTIEN_KHONG_HOP_LE);
        } else {
            this.soTien = soTien;
        }

    }

    public String getTrangThai() {
        return trangThai;
    }

    private void setTrangThai(String trangThai) {
        if (!(this.trangThai.equals("") || this.trangThai == null)
                && (trangThai.equals(TENTK_CHUA_XAC_DINH)
                || trangThai.equals(SOTIEN_KHONG_HOP_LE)
                || trangThai.equals(SOTK_KHONG_HOP_LE))
        ) {
            this.trangThai = this.trangThai + "; " + trangThai;
        }
        this.trangThai = trangThai;
    }

    /**
     * Default constructor của lớp tài khoản
     */
    public Account() {
        setTrangThai("");
        setSoTaiKhoan(SOTK_MAC_DINH);
        setTenTaiKhoan(TENTK_CHUA_XAC_DINH);
        setSoTien(SOTIEN_MAC_DINH);
    }

    /**
     * Constructor của lớp tài khoản
     * @param soTaiKhoan: số định danh cho mỗi tài khoản, là số dương và khác 999999
     * @param tenTaiKhoan: tên đăng kí cho tài khoản khác rỗng
     * @param soTien: số dư, số tiền có trong tài khoản >= 50
     * @param trangThai: hiển thị trạng thái lỗi
     */
    public Account(long soTaiKhoan, String tenTaiKhoan, double soTien, String trangThai) {
        setTrangThai("");
        setSoTaiKhoan(soTaiKhoan);
        setTenTaiKhoan(tenTaiKhoan);
        setSoTien(soTien);
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "vn");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return String.format("%-10d | %-25s | %20s",
                getSoTaiKhoan(),
                getTenTaiKhoan(),
                numberFormat.format(getSoTien())
        );
    }
}
