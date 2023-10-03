/*
 *  @ (#) QuanLyHangDoi.java      1.0 03/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise03;

import java.awt.event.KeyAdapter;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 03, 2023
 */
public class QuanLyHangDoi {
    private Deque<KhachHang> danhSachkhachHangChoMuaVe;
    private Deque<KhachHang> danhSachKhachHangDaMuaVe;

    public QuanLyHangDoi() {
        this.danhSachkhachHangChoMuaVe = new LinkedList<>();
        this.danhSachKhachHangDaMuaVe = new LinkedList<>();
    }

    public void themKhachHang(KhachHang khachHang){
        this.danhSachkhachHangChoMuaVe.add(khachHang);
    }

    public boolean banVeChoKhachHang(String soCMND){

        return false;
    }

    public KhachHang timKhachHangTheoSoCMND(String soCMND){
        return this.danhSachkhachHangChoMuaVe.stream()
                .filter(o -> o.getSoCMND().equalsIgnoreCase(soCMND))
                .findFirst()
                .orElse(null);
    }

}
