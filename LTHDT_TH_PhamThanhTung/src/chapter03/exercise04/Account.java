/*
 *  @ (#) Account.java      1.0 24/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise04;

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

    private static final double LAI_SUAT = 0.035;

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
            soTien = SOTIEN_MAC_DINH;
            setTrangThai(SOTIEN_KHONG_HOP_LE);
        }
        this.soTien = soTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    private void setTrangThai(String trangThai) {
        if (!getTrangThai().equals("")
                && (trangThai.equals(TENTK_CHUA_XAC_DINH)
                || trangThai.equals(SOTIEN_KHONG_HOP_LE)
                || trangThai.equals(SOTK_KHONG_HOP_LE))
        ) {
            this.trangThai = getTrangThai() + "; " + trangThai;
        }
        this.trangThai = trangThai;
    }

    /**
     * Default constructor của lớp tài khoản
     */
    public Account() {
        this.trangThai = "";
        setSoTaiKhoan(SOTK_MAC_DINH);
        setTenTaiKhoan(TENTK_CHUA_XAC_DINH);
        setSoTien(SOTIEN_MAC_DINH);
    }

    /**
     * Constructor 3 tham số của lớp tài khoản
     * @param soTaiKhoan: số định danh cho mỗi tài khoản, là số dương và khác 999999
     * @param tenTaiKhoan: tên đăng kí cho tài khoản khác rỗng
     * @param soTien: số dư, số tiền có trong tài khoản >= 50
     * @param trangThai: hiển thị trạng thái lỗi
     */
    public Account(long soTaiKhoan, String tenTaiKhoan, double soTien) {
        this.trangThai = "";
        setSoTaiKhoan(soTaiKhoan);
        setTenTaiKhoan(tenTaiKhoan);
        setSoTien(soTien);
    }

    /**
     * Constructor 2 tham số của lớp tài khoản
     * @param soTaiKhoan: số định danh cho mỗi tài khoản, là số dương và khác 999999
     * @param tenTaiKhoan: tên đăng kí cho tài khoản khác rỗng
     */
    public Account(long soTaiKhoan, String tenTaiKhoan) {
        this.trangThai = "";
        setSoTaiKhoan(soTaiKhoan);
        setTenTaiKhoan(tenTaiKhoan);
        setSoTien(SOTIEN_MAC_DINH);
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

    public void napTien(double soTien){
        if (!getTrangThai().equals("")) {
            System.out.printf("Tài khoản chưa hợp lệ, không được phép nạp tiền: %s.\n", getTrangThai());
            return;
        }
        if (soTien < 0) {
            System.out.println("Số tiền nạp chưa hợp lệ, xin vui lòng kiểm tra lại!");
            return;
        }
        this.soTien = getSoTien() + soTien;
        System.out.println("Tài khoản được nạp tiền thành công!");
    }

    public void rutTien(double soTien){
        if (!getTrangThai().equals("")) {
            System.out.printf("Tài khoản chưa hợp lệ, không được phép rút tiền: %s.\n", getTrangThai());
            return;
        }
        if (soTien < 0) {
            System.out.println("Số tiền muốn rút chưa hợp lệ, xin vui lòng kiểm tra lại!");
            return;
        }
        double soDu = getSoTien() - soTien;
        if (soDu < 0) {
            System.out.println("Số tiền muốn rút vượt quá số dư hiện tại, xin vui lòng chọn số tiền muốn rút khác!");
            return;
        }
        this.soTien = soDu;
        System.out.println("Tài khoản được rút tiền thành công!");
    }
    public void chuyenKhoan(Account other, double soTien) {
        // Giai đoạn kiểm tra tài khoản gửi và nhận có hợp lệ
        if (!getTrangThai().equals("")) {
            System.out.printf("Tài khoản chưa hợp lệ, không được phép chuyển khoản: %s.\n", getTrangThai());
            return;
        }
        if (!other.getTrangThai().equals("")) {
            System.out.printf("Tài khoản muốn chuyển khoản đến chưa hợp lệ, không được phép chuyển khoản.\n", getTrangThai());
            return;
        }
        // Giai đoạn kiểm tra số tiền muốn chuyển
        if (soTien < 0) {
            System.out.println("Số tiền muốn chuyển chưa hợp lệ, xin vui lòng kiểm tra lại!");
            return;
        }
        double soDu = getSoTien() - soTien;
        if (soDu < 0) {
            System.out.println("Số tiền muốn chuyển vượt quá số dư hiện tại, xin vui lòng chọn số tiền muốn rút khác!");
            return;
        }
        // Giai đoạn chuyển tiền từ tài khoản gửi
        rutTien(soTien);
        // Giai đoạn nhận tiền từ tài khoản nhận
        other.napTien(soTien);
        System.out.println("Chuyển khoản thành công!");
    }
    public void daoHan() {
        if (!getTrangThai().equals("")) {
            System.out.printf("Tài khoản chưa hợp lệ, không được phép đáo hạn: %s.\n", getTrangThai());
            return;
        }
        this.soTien = getSoTien() + getSoTien()*LAI_SUAT;
    }
}
