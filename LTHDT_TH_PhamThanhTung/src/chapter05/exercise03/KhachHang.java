/*
 *  @ (#) KhachHang.java      1.0 03/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise03;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 03, 2023
 */
public class KhachHang {
    private String soCMND;
    private String tenKH;
    private String tenGaDen;
    private double giaTien;

    public KhachHang() {
        this("","","",0.0);
    }

    public KhachHang(String soCMND, String tenKH, String tenGaDen, double giaTien) {
        setSoCMND(soCMND);
        setTenKH(tenKH);
        setTenGaDen(tenGaDen);
        setGiaTien(giaTien);
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenGaDen() {
        return tenGaDen;
    }

    public void setTenGaDen(String tenGaDen) {
        this.tenGaDen = tenGaDen;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %,.2f VND", this.soCMND, this.tenKH, this.tenGaDen, this.giaTien);
    }
}
