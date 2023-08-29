/*
 *  @ (#) QuanLySinhVien.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise13;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class QuanLySinhVien {
    public final static String TRUNG_CAP = "754923HNSFNSKHF7838BNFSN893HFN93NF89234HNF9R";
    public final static String CAO_DANG = "754923HNSFNSKHF7838BNFSN093HFN93NF89234HNF9R";
    public final static String DAI_HOC = "754923HNSFNSKHF7838BNFSN793HFN93NF89234HNF9R";
    private List<SinhVien> sinhVienList;

    public QuanLySinhVien() {
        this.sinhVienList = new ArrayList<>();
    }
    public void nhapThongTin(SinhVien sinhVien) {
        this.sinhVienList.add(sinhVien);
    }
    public void nhapThongTin(String mssv, String hoTen, LocalDate ngaySinh, String noiSinh, String nganh, String khoa, String loaiSvHoacQuocGia){
        SinhVien sinhVien = null;
        if (loaiSvHoacQuocGia.equals(TRUNG_CAP)) {
            sinhVien = new SinhVienTrungCap(mssv, hoTen, ngaySinh, noiSinh, nganh, khoa);
        } else if (loaiSvHoacQuocGia.equals(CAO_DANG)) {
            sinhVien = new SinhVienCaoDang(mssv, hoTen, ngaySinh, noiSinh, nganh, khoa);
        } else if (loaiSvHoacQuocGia.equals(DAI_HOC)) {
            sinhVien = new SinhVienDaiHoc(mssv, hoTen, ngaySinh, noiSinh, nganh, khoa);
        } else {
            sinhVien = new SinhVienLienKet(mssv, hoTen, ngaySinh, noiSinh, nganh, khoa, loaiSvHoacQuocGia);
        }
        this.sinhVienList.add(sinhVien);
    }

    public void xuatThongTin(){
        for (SinhVien sv: this.sinhVienList) {
            if (sv instanceof SinhVienTrungCap) {
                sv = (SinhVienTrungCap) sv;
            } else if (sv instanceof  SinhVienCaoDang) {
                sv = (SinhVienCaoDang) sv;
            } else if (sv instanceof SinhVienDaiHoc) {
                sv = (SinhVienDaiHoc) sv;
            } else {
                sv = (SinhVienLienKet) sv;
            }
            System.out.println(sv);
        }
    }
}
