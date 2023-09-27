/*
 *  @ (#) Phong.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise02;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public abstract class Phong {
    private String maPhong;
    private String dayNha;
    private double dienTich;
    private int soLuongBongDen;

    public Phong() {
        this("", "", 0.0, 0);
    }

    public Phong(String maPhong, String dayNha, double dienTich, int soLuongBongDen) {
        setMaPhong(maPhong);
        setDayNha(dayNha);
        setDienTich(dienTich);
        setSoLuongBongDen(soLuongBongDen);
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoLuongBongDen() {
        return soLuongBongDen;
    }

    public void setSoLuongBongDen(int soLuongBongDen) {
        this.soLuongBongDen = soLuongBongDen;
    }

    public abstract boolean datChuan();
    public boolean datDuSoLuongDen(){
        int soLuongBongDenCanThiet = (int) Math.ceil(this.getDienTich()/ 10);
        if (this.getSoLuongBongDen() >= soLuongBongDenCanThiet){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Diện tích=%.2f | Số bóng đèn=%d", this.dienTich, this.soLuongBongDen);
    }
}
