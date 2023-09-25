/*
 *  @ (#) HangDienMay.java      1.0 20/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise11;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 20, 2023
 */
public class HangDienMay extends HangHoa{
    private int soThangBaoHanh;
    private int congSuat;   // KW

    public HangDienMay(String maHang, String tenHang, int soLuong, double donGia, int soThangBaoHanh, int congSuat) {
        super(maHang, tenHang, soLuong, donGia, 0.1);
        setSoThangBaoHanh(soThangBaoHanh);
        setCongSuat(congSuat);
    }

    public int getSoThangBaoHanh() {
        return soThangBaoHanh;
    }

    public void setSoThangBaoHanh(int soThangBaoHanh) {
        if (soThangBaoHanh < 0){
            soThangBaoHanh = 0;
        }
        this.soThangBaoHanh = soThangBaoHanh;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        if (congSuat <= 0) {
            throw new IllegalArgumentException("Số công suất phải lớn hơn 0");
        }
        this.congSuat = congSuat;
    }

    @Override
    public String danhGia() {
        String danhGia = null;
        if (getSoLuong() < 3){
            danhGia = "bán được";
        }
        return danhGia;
    }

    @Override
    public String toString() {
        return "HangDienMay [" +
                super.toString() +
                ", soThangBaoHanh=" + soThangBaoHanh +
                ", congSuat=" + congSuat +
                ']';
    }
}
