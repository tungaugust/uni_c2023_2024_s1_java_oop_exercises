/*
 *  @ (#) PhongMayTinh.java      1.0 27/09/2023
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
public class PhongMayTinh extends Phong{
    private int soLuongMayTinh;

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soLuongBongDen, int soLuongMayTinh) {
        super(maPhong, dayNha, dienTich, soLuongBongDen);
        setSoLuongMayTinh(soLuongMayTinh);
    }

    public int getSoLuongMayTinh() {
        return soLuongMayTinh;
    }

    public void setSoLuongMayTinh(int soLuongMayTinh) {
        this.soLuongMayTinh = soLuongMayTinh;
    }

    @Override
    public boolean datChuan() {
        int soLuongMayTinhCanThiet = (int) Math.ceil(this.getDienTich()/ 1.5);
        if (this.datDuSoLuongDen() && this.getSoLuongMayTinh() >= soLuongMayTinhCanThiet){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Phòng máy tính [%s | Số máy tính=%d | Đánh giá=%s]",
                super.toString(),
                this.soLuongMayTinh,
                (datChuan()) ? "Đạt" : "Không đạt"
        );
    }
}
