/*
 *  @ (#) HinhChuNhat.java      1.0 22/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise3;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 22, 2023
 */
public class HinhChuNhat {
    double chieuDai;
    double chieuRong;

    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        if (chieuDai < 0) {
            chieuDai = 0;
        }
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        if (chieuRong < 0){
            chieuRong = 0;
        }
        this.chieuRong = chieuRong;
    }

    public double dienTich(){
        return getChieuDai() * getChieuRong();
    }

    public double chuVi(){
        if ((getChieuRong() == 0) || (getChieuDai() == 0)) {
            return 0;
        }
        return 2 * (getChieuDai() + getChieuRong());
    }

    @Override
    public String toString() {
        return "HinhChuNhat[" +
                "chiều dài =" + chieuDai +
                ", chiều rộng =" + chieuRong +
                ", diện tích =" + dienTich() +
                ", chu vi =" + chuVi() +
                ']';
    }
}
