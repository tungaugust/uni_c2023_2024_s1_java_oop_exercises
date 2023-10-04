/*
 *  @ (#) QuanLyHangDoi.java      1.0 03/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise03;

import java.awt.event.KeyAdapter;
import java.io.FileWriter;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

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

    private KhachHang timKhachHangTheoSoCMND(String soCMND){
        if (this.danhSachkhachHangChoMuaVe.isEmpty()) {
            return null;
        }
        return this.danhSachkhachHangChoMuaVe.stream()
                .filter(o -> o.getSoCMND().equalsIgnoreCase(soCMND))
                .findFirst()
                .orElse(null);
    }

    public void themKhachHang(KhachHang khachHang){
        KhachHang khachHangTester = timKhachHangTheoSoCMND(khachHang.getSoCMND());
        if (khachHangTester == null) {
            this.danhSachkhachHangChoMuaVe.add(khachHang);
        } else {
            khachHangTester.setTenGaDen(khachHang.getTenGaDen());
            khachHangTester.setGiaTien(khachHang.getGiaTien());
        }
    }

    public KhachHang banVeChoKhachHang(){
        if (this.danhSachkhachHangChoMuaVe.isEmpty()){
            return null;
        }
        KhachHang khachHang = this.danhSachkhachHangChoMuaVe.removeFirst();
        this.danhSachKhachHangDaMuaVe.add(khachHang);
        return khachHang;
    }

    public KhachHang huyKhachHang(String soCMND){
        KhachHang khachHang = timKhachHangTheoSoCMND(soCMND);
        if (khachHang == null) {
            return null;
        }
        this.danhSachkhachHangChoMuaVe.remove(khachHang);
        return khachHang;
    }

    public void hienThiDanhSachKhachHang(){
        if (this.danhSachkhachHangChoMuaVe.isEmpty()) {
            return;
        }
        this.danhSachkhachHangChoMuaVe.stream()
                .forEach(o -> System.out.println(o));
    }

    private int soLuongKhachHangDaMuaVe(){
        return this.danhSachKhachHangDaMuaVe.size();
    }
    private int soLuongKhachHangTrongHangDoi(){
        return this.danhSachkhachHangChoMuaVe.size();
    }

    private double tongDoanhThuBanVe(){
        if (this.danhSachKhachHangDaMuaVe.isEmpty()) {
            return 0.0;
        }
        return this.danhSachKhachHangDaMuaVe.stream()
                .collect(Collectors.summingDouble(KhachHang::getGiaTien));
    }
    public void thongKeTinhHinhBanVe(){
        System.out.println("Số lượng khách hàng chờ nhận vé: " + soLuongKhachHangTrongHangDoi());
        System.out.println("Số lượng khách hàng đã nhận vé: " + soLuongKhachHangDaMuaVe());
        System.out.printf("Tổng doanh thu: %,.2f VND\n", tongDoanhThuBanVe());
    }

    public void luuDanhSachKhachHangTrongHangDoi(){
        if (this.danhSachkhachHangChoMuaVe.isEmpty()) {
            return;
        }
        try {
            FileWriter fw = new FileWriter("src/chapter05/exercise03/danhSachKhachHang.txt");
            String str = this.danhSachkhachHangChoMuaVe.stream()
                    .map(o -> o.toString())
                    .collect(Collectors.joining("\n"));
            fw.write(str);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void hienThiDanhSachCacGaDangChoMuaVe(){
        if (this.danhSachkhachHangChoMuaVe.isEmpty()) {
            return;
        }
        this.danhSachkhachHangChoMuaVe.stream()
                .map(o -> o.getTenGaDen())
                .collect(Collectors.toCollection(() -> new HashSet<>()))
                .forEach(o -> System.out.println(o));
    }

    public void hienThiDanhSachCacGaDangChoMuaVeVaSoVeTuongUng(){
        if (this.danhSachkhachHangChoMuaVe.isEmpty()) {
            return;
        }
        this.danhSachkhachHangChoMuaVe.stream()
                .map(o -> o.getTenGaDen())
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
