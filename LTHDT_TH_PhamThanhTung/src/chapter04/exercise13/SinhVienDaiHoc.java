/*
 *  @ (#) SinhVienDaiHoc.java      1.0 29/08/2023
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
public class SinhVienDaiHoc extends SinhVien{

    public SinhVienDaiHoc(String mssv, String hoTen, LocalDate ngaySinh, String noiSinh, String nganh, String khoa) {
        super(mssv, hoTen, ngaySinh, noiSinh, nganh, khoa);
    }
}
