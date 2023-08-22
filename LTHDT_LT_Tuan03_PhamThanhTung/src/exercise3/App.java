/*
 *  @ (#) App.java      1.0 22/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise3;

/**
 * Chương trình tạo hình chữ nhật từ lớp HinhChuNhat
 * @author: tungpt
 * @version: 1.0
 * @since: August 22, 2023
 */
public class App {
    public static void main(String[] args) {
        HinhChuNhat hinhChuNhat1 = new HinhChuNhat();
        HinhChuNhat hinhChuNhat2 = new HinhChuNhat();
        HinhChuNhat hinhChuNhat3 = new HinhChuNhat();

        hinhChuNhat1.setChieuDai(10);
        System.out.println(hinhChuNhat1);

        hinhChuNhat2.setChieuDai(10);
        hinhChuNhat2.setChieuRong(5);
        System.out.println(hinhChuNhat2);

        hinhChuNhat3.setChieuDai(-5);
        hinhChuNhat3.setChieuRong(5);
        System.out.println(hinhChuNhat3);
    }
}
