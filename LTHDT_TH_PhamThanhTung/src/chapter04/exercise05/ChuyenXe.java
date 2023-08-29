/*
 *  @ (#) ChuyenXe.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise05;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public abstract class ChuyenXe {

    public final static String NOI_THANH = "chuyến xe nội thành";
    public final static String NGOAI_THANH = "chuyến xe ngoại thành";

    private String maChuyenXe;  // mã chuyến xe
    private String tenTaiXe;    // họ tên tài xế
    private String soXe;    // biển số xe
    private double doanhThu;    // doanh thu

    public ChuyenXe() {
        this.maChuyenXe = "XXXX";
        this.tenTaiXe = "No name";
        this.soXe = "000-000.00";
        this.doanhThu = 0.0;
    }

    public ChuyenXe(String maChuyenXe, String tenTaiXe, String soXe, double doanhThu) {
        setMaChuyenXe(maChuyenXe);
        setTenTaiXe(tenTaiXe);
        setSoXe(soXe);
        setDoanhThu(doanhThu);
    }

    public String getMaChuyenXe() {
        return maChuyenXe;
    }

    public void setMaChuyenXe(String maChuyenXe) {
        if (maChuyenXe.equals("")) {
            throw new IllegalArgumentException("Mã chuyến xe không được rỗng");
        }
        this.maChuyenXe = maChuyenXe;
    }

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        if (tenTaiXe.equals("")) {
            throw new IllegalArgumentException("Tên tài xế không được rỗng");
        }
        this.tenTaiXe = tenTaiXe;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        if (soXe.equals("")) {
            throw new IllegalArgumentException("Số xe không được rỗng");
        }
        this.soXe = soXe;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        if (doanhThu < 0) {
            doanhThu = 0.0;
        }
        this.doanhThu = doanhThu;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        return String.format("%-10s | %-20s | %10s | %20s", maChuyenXe, tenTaiXe, soXe, decimalFormat.format(doanhThu));
    }
}
