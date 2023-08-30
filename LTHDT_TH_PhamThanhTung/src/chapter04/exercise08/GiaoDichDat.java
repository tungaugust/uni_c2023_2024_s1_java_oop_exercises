/*
 *  @ (#)
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise08;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 30, 2023
 */
public class GiaoDichDat extends GiaoDichNhaDat{
    public final static String LOAI_A = "đất loại A";
    public final static String LOAI_B = "đất loại B";
    public final static String LOAI_C = "đất loại C";

    public GiaoDichDat() {
        super();
    }

    public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, String loai, double dienTich) {
        super(maGiaoDich, ngayGiaoDich, donGia, loai, dienTich);
    }

    @Override
    public double thanhTien() {
        if (getLoai().equals(LOAI_B) || getLoai().equals(LOAI_C)) {
            return getDonGia() * getDienTich();
        }
        if (getLoai().equals(LOAI_A)) {
            return getDonGia() * getDienTich() * 1.5;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
