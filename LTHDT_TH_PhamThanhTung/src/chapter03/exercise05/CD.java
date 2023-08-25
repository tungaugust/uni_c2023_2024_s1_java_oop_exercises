/*
 *  @ (#) CD.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise05;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public class CD {
    private long maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    public long getMaCD() {
        return maCD;
    }

    private static final long MA_CD = 999999l;
    private static final String TUA_CD = "chưa xác định";

    public void setMaCD(long maCD) {
        if (maCD <= 0) {
            maCD = MA_CD;
        }
        this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD == null || tuaCD.equals("")) {
            tuaCD = TUA_CD;
        }
        this.tuaCD = tuaCD;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat <= 0) {
            throw new RuntimeException("Số lượng bài hát phải lớn hơn 0.");
        }
        this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh <= 0) {
            throw new RuntimeException("Giá thành CD phải lớn hơn 0.");
        }
        this.giaThanh = giaThanh;
    }

    public CD(){
        this.maCD = MA_CD;
        this.tuaCD = TUA_CD;
    }
    public CD(long maCD, String tuaCD, int soBaiHat, double giaThanh) {
        setMaCD(maCD);
        setTuaCD(tuaCD);
        setSoBaiHat(soBaiHat);
        setGiaThanh(giaThanh);
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "vn");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return String.format("%-10d | %-25s | %15s | %20s",
                getMaCD(),
                getTuaCD(),
                getSoBaiHat(),
                numberFormat.format(getGiaThanh())
        );
    }
}
