/*
 *  @ (#) PhongLyThuyet.java      1.0 27/09/2023
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
public class PhongLyThuyet extends Phong{
    private boolean mayChieu;

    public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soLuongBongDen, boolean mayChieu) {
        super(maPhong, dayNha, dienTich, soLuongBongDen);
        setMayChieu(mayChieu);
    }

    public boolean hasMayChieu() {
        return mayChieu;
    }

    public void setMayChieu(boolean mayChieu) {
        this.mayChieu = mayChieu;
    }

    @Override
    public boolean datChuan() {
        return this.datDuSoLuongDen() && hasMayChieu();
    }

    @Override
    public String toString() {
        return String.format("Phòng lý thuyết [%s | Máy chiếu=%s | Đánh giá=%s]",
                super.toString(),
                (this.mayChieu) ? "Có" : "Không",
                (datChuan()) ? "Đạt" : "Không đạt"
        );
    }
}
