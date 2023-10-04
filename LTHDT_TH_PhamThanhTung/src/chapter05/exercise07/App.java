/*
 *  @ (#) App.java      1.0 04/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise07;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 04, 2023
 */
public class App {
    public static void main(String[] args) {
        DanhBaDienThoai danhBa = new DanhBaDienThoai();
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456789"), new DiaChi("A"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456781"), new DiaChi("A"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456782"), new DiaChi("C"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456783"), new DiaChi("B"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456784"), new DiaChi("C"));
        danhBa.dangKiSoDienThoai(new SoDienThoai("0123456785"), new DiaChi("D"));

        System.out.println("Hiển thị danh bạ tăng dần theo số điện thoại");
        danhBa.hienThiDanhBaTangDanTheoSoDienThoai();
        System.out.println("Hiển thị danh bạ tăng dần theo địa chỉ");
        danhBa.hienThiDanhBaTangDanTheoDiaChi();
    }
}
