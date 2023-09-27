/*
 *  @ (#) QuanLyPhong.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public class QuanLyPhong {
    private List<Phong> phongList;

    public QuanLyPhong() {
        this.phongList = new ArrayList<>();
    }

    public boolean themPhong(Phong phong){
        Phong p = timPhongTheoMaPhong(phong.getMaPhong());
        if (p == null) {
            this.phongList.add(phong);
            return true;
        }
        return false;
    }

    public Phong timPhongTheoMaPhong(String maPhong){
        return phongList.stream()
                .filter(o -> o.getMaPhong().equalsIgnoreCase(maPhong))
                .findFirst()
                .orElse(null);
    }

    public void inDanhSachTatCaPhong(){
        this.phongList.stream().forEach(o -> System.out.println(o));
    }

    public void inDanhSachCacPhongDatChuan(){
        this.phongList.stream().filter(o -> o.datChuan()).forEach(o -> System.out.println(o));
    }

    public void sapXepDanhSachTheoDayNha(){
        this.phongList = this.phongList.stream()
                .sorted(Comparator.comparing(Phong::getDayNha))
                .collect(Collectors.toList());
    }
    public void sapXepDanhSachGiamDanTheoDienTich(){
        this.phongList = this.phongList.stream()
                .sorted(Comparator.comparing(Phong::getDienTich).reversed())
                .collect(Collectors.toList());
    }
    public void sapXepDanhSachTheoBongDen(){
        this.phongList = this.phongList.stream()
                .sorted(Comparator.comparing(Phong::getSoLuongBongDen))
                .collect(Collectors.toList());
    }

    public boolean capNhatSoMayTinh(String maPhong, int soLuong){
        Phong phong = timPhongTheoMaPhong(maPhong);
        if (phong == null || !(phong instanceof PhongMayTinh)) {
            return false;
        }
        ((PhongMayTinh) phong).setSoLuongMayTinh(soLuong);
        return true;
    }

    public boolean xoaPhong(String maPhong){
        Phong phong = timPhongTheoMaPhong(maPhong);
        if (phong == null) {
            return false;
        }
        return this.phongList.remove(phong);
    }

    public int tongSoPhong(){
        return this.phongList.size();
    }

    public void inDanhSachPhongMayTinhCo60May(){
        this.phongList.stream()
                .filter(o -> o instanceof PhongMayTinh && ((PhongMayTinh) o).getSoLuongMayTinh() == 60)
                .forEach(o -> System.out.println(o));
    }
}
