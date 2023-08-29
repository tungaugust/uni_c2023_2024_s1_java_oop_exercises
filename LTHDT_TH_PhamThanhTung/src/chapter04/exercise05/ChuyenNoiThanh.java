/*
 *  @ (#) ChuyenNoiThanh.java      1.0 29/08/2023
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
public class ChuyenNoiThanh extends ChuyenXe {
    private String soTuyen; // số tuyến xe
    private int quangDuong; // số Km đã đi được

    public ChuyenNoiThanh() {
        super();
        this.soTuyen = "00";
        this.quangDuong = 0;
    }

    public ChuyenNoiThanh(String maChuyenXe, String tenTaiXe, String soXe, double doanhThu, String soTuyen, int quangDuong) {
        super(maChuyenXe, tenTaiXe, soXe, doanhThu);
        setSoTuyen(soTuyen);
        setQuangDuong(quangDuong);
    }

    public String getSoTuyen() {
        return soTuyen;
    }

    public void setSoTuyen(String soTuyen) {
        if (soTuyen.equals("")) {
            throw new IllegalArgumentException("Số tuyến không được rỗng");
        }
        this.soTuyen = soTuyen;
    }

    public int getQuangDuong() {
        return quangDuong;
    }

    public void setQuangDuong(int quangDuong) {
        if (quangDuong < 0) {
            quangDuong = 0;
        }
        this.quangDuong = quangDuong;
    }

    @Override
    public String toString() {
        return String.format("%s | %-10s | %10d", super.toString(), soTuyen, quangDuong);
    }
}
