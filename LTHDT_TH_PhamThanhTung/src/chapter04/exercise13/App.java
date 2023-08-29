/*
 *  @ (#) App.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise13;

import java.time.LocalDate;

/**
 * Chương trình nhập, xuất thông tin sinh viên
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class App {
    public static void main(String[] args) {
        QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
        SinhVien sinhVien1 = new SinhVienTrungCap("1819061","Phan Huy Quang",
                LocalDate.of(2000, 9, 12), "Tuyên Quang", "Kỹ thuật phần mềm", "CNTT");
        SinhVien sinhVien2 = new SinhVienCaoDang("1819062","Lâm Viết Nhất",
                LocalDate.of(2000, 8, 15), "Quảng Nam", "Khoa học máy tính", "CNTT");
        SinhVien sinhVien3 = new SinhVienDaiHoc("1819063","Hoàng Dương",
                LocalDate.of(2000, 7, 17),"Hải Phòng", "Kỹ thuật phần mềm","CNTT");
        SinhVien sinhVien4 = new SinhVienLienKet("1819064","Joseph Smith",
                LocalDate.of(1999, 12, 7), "Texas", "Khoa học máy tính", "CNTT", "Hoa Kỳ");
        quanLySinhVien.nhapThongTin(sinhVien1);
        quanLySinhVien.nhapThongTin(sinhVien2);
        quanLySinhVien.nhapThongTin(sinhVien3);
        quanLySinhVien.nhapThongTin(sinhVien4);
        quanLySinhVien.nhapThongTin("1819071","Trần Tín Nghĩa",
                LocalDate.of(2000, 5, 10), "Nghệ An", "Kỹ thuật phần mềm", "CNTT", QuanLySinhVien.DAI_HOC);
        quanLySinhVien.nhapThongTin("1819072","Intha",
                LocalDate.of(2000, 2, 18), "Vientiane", "Khoa học máy tính", "CNTT", "Lào");

        quanLySinhVien.xuatThongTin();
    }
}
