/*
 *  @ (#) PhongThiNghiem.java      1.0 27/09/2023
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
public class PhongThiNghiem extends Phong{

    private boolean bonRua;

    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soLuongBongDen, boolean bonRua) {
        super(maPhong, dayNha, dienTich, soLuongBongDen);
        setBonRua(bonRua);
    }

    public boolean hasBonRua() {
        return bonRua;
    }

    public void setBonRua(boolean bonRua) {
        this.bonRua = bonRua;
    }

    @Override
    public boolean datChuan() {
        return this.datDuSoLuongDen() && hasBonRua();
    }

    @Override
    public String toString() {
        return String.format("Phòng lý thuyết [%s | Bồn rửa=%s | Đánh giá=%s]",
                super.toString(),
                (this.bonRua) ? "Có" : "Không",
                (datChuan()) ? "Đạt" : "Không đạt"
        );
    }
}
