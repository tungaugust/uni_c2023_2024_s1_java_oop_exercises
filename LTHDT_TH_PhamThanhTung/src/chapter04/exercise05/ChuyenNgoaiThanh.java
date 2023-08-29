/*
 *  @ (#) ChuyenNgoaiThanh.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise05;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class ChuyenNgoaiThanh extends ChuyenXe {
    private String noiDen;  // nơi đến
    private int soNgay; // số ngày đi được

    public ChuyenNgoaiThanh(String noiDen, int soNgay) {
        super();
        this.noiDen = "No location";
        this.soNgay = 0;
    }

    public ChuyenNgoaiThanh(String maChuyenXe, String tenTaiXe, String soXe, double doanhThu, String noiDen, int soNgay) {
        super(maChuyenXe, tenTaiXe, soXe, doanhThu);
        setNoiDen(noiDen);
        setSoNgay(soNgay);
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        if (noiDen.equals("")) {
            throw new IllegalArgumentException("Điểm đến không được rỗng");
        }
        this.noiDen = noiDen;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        if (soNgay < 0){
            soNgay = 0;
        }

        this.soNgay = soNgay;
    }

    @Override
    public String toString() {
        return String.format("%s | %-20s | %10d", super.toString(), noiDen, soNgay);
    }
}
