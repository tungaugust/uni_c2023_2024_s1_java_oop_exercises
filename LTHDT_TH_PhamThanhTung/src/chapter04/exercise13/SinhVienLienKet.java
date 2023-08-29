/*
 *  @ (#) SinhVienLienKet.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise13;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class SinhVienLienKet extends SinhVien{
    private String quocGia; // quốc gia của sinh viên liên kết

    public SinhVienLienKet(String mssv, String hoTen, LocalDate ngaySinh, String noiSinh, String nganh, String khoa, String quocGia) {
        super(mssv, hoTen, ngaySinh, noiSinh, nganh, khoa);
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", super.toString(), quocGia);
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        if (quocGia.equals("")) {
            throw new IllegalArgumentException("Tên quốc gia không được để rỗng");
        }
        this.quocGia = quocGia;
    }
}
