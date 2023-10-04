/*
 *  @ (#) DanhBaDienThoai.java      1.0 04/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 04, 2023
 */
public class DanhBaDienThoai {
    private Map<SoDienThoai, DiaChi> danhBaSoDienThoai;

    public DanhBaDienThoai(){
        this.danhBaSoDienThoai = new HashMap<>();
    }

    public boolean dangKiSoDienThoai(DiaChi diaChi, SoDienThoai soDienThoai){
        return dangKiSoDienThoai(soDienThoai, diaChi);
    }
    public boolean dangKiSoDienThoai(SoDienThoai soDienThoai, DiaChi diaChi){
        boolean soDienThoaiDaDuocDangKi = this.danhBaSoDienThoai.containsKey(soDienThoai);
        if (soDienThoaiDaDuocDangKi) {
            return false;
        }
        this.danhBaSoDienThoai.put(soDienThoai, diaChi);
        return true;
    }

    public boolean xoaSoDienThoai(SoDienThoai soDienThoai){
        return (this.danhBaSoDienThoai.remove(soDienThoai) == null) ? false : true;
    }

    public Set<SoDienThoai> traCuuTheoDiaChi(DiaChi diaChi) {
        return this.danhBaSoDienThoai.entrySet().stream()
                .filter(o -> o.getValue() == diaChi)
                .map(o -> o.getKey())
                .collect(Collectors.toCollection(
                        () -> new HashSet<>()
                ));
    }
    public Set<SoDienThoai> traCuuTheoDiaChi(String diaChi) {
        return traCuuTheoDiaChi(new DiaChi(diaChi));
    }

    public DiaChi traCuuTheoSoDienThoai(SoDienThoai soDienThoai){
        return this.danhBaSoDienThoai.get(soDienThoai);
    }

    public void hienThiDanhBaTangDanTheoSoDienThoai(){
        this.danhBaSoDienThoai.entrySet().stream()
                .sorted(Comparator.comparing(o -> o.getKey().getSoDienThoai()))
                .forEach(o -> System.out.println(o.getKey().getSoDienThoai() + ": " + o.getValue().getDiaChi()));
    }
    public void hienThiDanhBaTangDanTheoDiaChi(){
        this.danhBaSoDienThoai.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new))
                .entrySet().stream()
                .sorted(Comparator.comparing(o -> o.getValue().getDiaChi()))
                .forEach(o -> System.out.println(o.getKey().getSoDienThoai() + ": " + o.getValue().getDiaChi()));
    }
}
