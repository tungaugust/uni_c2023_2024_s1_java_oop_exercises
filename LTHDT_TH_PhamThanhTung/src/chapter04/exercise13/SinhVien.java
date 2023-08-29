/*
 *  @ (#) SinhVien.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public abstract class SinhVien {
    private String mssv;    // mã số sinh viên
    private String hoTen;   // họ tên sinh viên
    private LocalDate ngaySinh; // ngày sinh
    private String noiSinh; // nơi sinh của sinh viên
    private String nganh;   // ngành học của sinh viên
    private String khoa;    // khoa của sinh viên

    public SinhVien(String mssv, String hoTen, LocalDate ngaySinh, String noiSinh, String nganh, String khoa) {
        setMssv(mssv);
        setHoTen(hoTen);
        setNgaySinh(ngaySinh);
        setNoiSinh(noiSinh);
        setNganh(nganh);
        setKhoa(khoa);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s | %s | %s | %s | %s | %s",
                mssv,
                hoTen,
                ngaySinh.format(dateTimeFormatter),
                noiSinh,
                nganh,
                khoa);
    }

    private void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getMssv() {
        return mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
