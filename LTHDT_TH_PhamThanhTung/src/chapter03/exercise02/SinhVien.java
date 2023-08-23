/*
 *  @ (#) SinhVien.java      1.0 23/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise02;

/**
 * Lớp sinh viên
 * @author: tungpt
 * @version: 1.0
 * @since: August 23, 2023
 */
public class SinhVien {
    private int maSinhVien;
    private String hoTen;
    private float diemLT;
    private float diemTH;

    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        if (maSinhVien < 0) {
            maSinhVien = 0;
        }
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        if (hoTen.equals("")) {
            hoTen = "Chưa xác định";
        }
        this.hoTen = hoTen;
    }

    public float getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        if (diemLT < 0 || diemLT > 10) {
            diemLT = 0.0f;
        }
        this.diemLT = diemLT;
    }

    public float getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        if (diemTH < 0 || diemTH > 10) {
            diemTH = 0.0f;
        }
        this.diemTH = diemTH;
    }

    /**
     * Default constructor của lớp SinhVien
     */
    public SinhVien(){
        this.maSinhVien = 0;
        this.hoTen = "";
        this.diemTH = 0.0f;
        this.diemLT = 0.0f;
    }

    /**
     * Constructor đầy đủ của lớp SinhVien
     * @param maSinhVien: mã số sinh viên
     * @param hoTen: họ và tên sinh viên
     * @param diemLT: điểm lý thuyết của sinh viên
     * @param diemTH: điểm thực hành của sinh viên
     */
    public SinhVien(int maSinhVien, String hoTen, float diemLT, float diemTH) {
        setMaSinhVien(maSinhVien);
        setHoTen(hoTen);
        setDiemLT(diemLT);
        setDiemTH(diemTH);
    }

    /**
     * Tính điểm trung bình của đối tượng sinh viên
     * @return điểm trung bình
     */
    public float diemTrungBinh() {
        return (getDiemLT() + getDiemTH())/2;
    }

    /**
     * Biển diễn đối tượng lớp SinhVien dạng chuỗi
     * @return Chuỗi biểu diễn của đối tượng lớp SinhVien
     */
    @Override
    public String toString() {
        return String.format("%-6d | %-30s | %10.2f | %10.2f | %10.2f",
                getMaSinhVien(), getHoTen(), getDiemLT(), getDiemTH(), diemTrungBinh()
        );
    }
}
