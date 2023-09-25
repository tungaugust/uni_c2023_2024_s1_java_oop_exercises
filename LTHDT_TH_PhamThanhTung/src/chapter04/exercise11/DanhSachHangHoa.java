/*
 *  @ (#) DanhSachHangHoa.java      1.0 20/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 20, 2023
 */
public class DanhSachHangHoa {
    private HangHoa[] danhSachHangHoa;
    private int soLuong;

    public DanhSachHangHoa(){
        this.danhSachHangHoa = new HangHoa[5];
        this.soLuong = 0;
    }

    public boolean them(HangHoa hangHoa){
        int index = laySoChi(hangHoa.getMaHang());
        if (index >= 0) {
            return false;
        }
        if (this.soLuong >= this.danhSachHangHoa.length) {
            moRongDanhSach();
        }
        this.soLuong++;
        this.danhSachHangHoa[this.soLuong - 1] = hangHoa;
        return true;
    }

    public boolean them(Scanner scanner) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        String duLieuNhap;
        int loaiHangHoa;
        HangHoa hangHoa = null;
        String tenHang;
        String maHang;
        int soLuong;
        double donGia;
        LocalDate ngaySanXuat, ngayHetHan, ngayNhapKho;
        String nhaCungCap;
        int soThangBaoHanh;
        int congSuat;
        System.out.print("Nhập loại hàng hoá [1-Hàng thực phẩm (mặc định); 2-Hàng sành sứ; 3-Hàng điện máy]: ");
        duLieuNhap = scanner.nextLine().trim();
        try {
            loaiHangHoa = Integer.valueOf(duLieuNhap);
        } catch (NumberFormatException e) {
            loaiHangHoa = 1;
        }
        System.out.print("Nhập mã hàng: ");
        maHang = scanner.nextLine().trim();
        System.out.print("Nhập tên hàng: ");
        tenHang = scanner.nextLine().trim();
        System.out.print("Nhập số lượng tồn kho: ");
        duLieuNhap = scanner.nextLine().trim();
        try {
            soLuong = Integer.valueOf(duLieuNhap);
        } catch (NumberFormatException e) {
            soLuong = 0;
        }
        System.out.print("Nhập đơn giá: ");
        duLieuNhap = scanner.nextLine().trim();
        try {
            donGia = Integer.valueOf(duLieuNhap);
        } catch (NumberFormatException e) {
            donGia = 0.0;
        }
        switch (loaiHangHoa) {
            case 2:
                System.out.print("Nhập ngày sản xuất (Vd: 25/5/2023): ");
                duLieuNhap = scanner.nextLine().trim();
                try {
                    ngaySanXuat = LocalDate.parse(duLieuNhap, dateTimeFormatter);
                } catch (DateTimeParseException e) {
                    ngaySanXuat = LocalDate.now();
                }
                System.out.print("Nhập ngày nhập kho (Vd: 25/5/2023): ");
                duLieuNhap = scanner.nextLine().trim();
                try {
                    ngayNhapKho = LocalDate.parse(duLieuNhap, dateTimeFormatter);
                } catch (DateTimeParseException e) {
                    ngayNhapKho = LocalDate.now();
                }
                try {
                    hangHoa = new HangSanhSu(maHang, tenHang, soLuong, donGia, ngaySanXuat, ngayNhapKho);
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }

                break;
            case 3:
                try {
                    System.out.println("Nhập số tháng bảo hành: ");
                    soThangBaoHanh = Integer.valueOf(duLieuNhap);
                } catch (NumberFormatException e) {
                    soThangBaoHanh = 0;
                }
                try {
                    System.out.println("Nhập số công suất: ");
                    congSuat = Integer.valueOf(duLieuNhap);
                } catch (NumberFormatException e) {
                    congSuat = 0;
                }
                try {
                    hangHoa = new HangDienMay(maHang, tenHang, soLuong, donGia, soThangBaoHanh, congSuat);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.print("Nhập ngày sản xuất (Vd: 25/5/2023): ");
                duLieuNhap = scanner.nextLine().trim();
                try {
                    ngaySanXuat = LocalDate.parse(duLieuNhap, dateTimeFormatter);
                } catch (DateTimeParseException e) {
                    ngaySanXuat = LocalDate.now();
                }
                System.out.print("Nhập ngày hết hạn (Vd: 25/5/2023): ");
                duLieuNhap = scanner.nextLine().trim();
                try {
                    ngayHetHan = LocalDate.parse(duLieuNhap, dateTimeFormatter);
                } catch (DateTimeParseException e) {
                    ngayHetHan = LocalDate.now();
                }
                System.out.print("Nhập tên nhà cung cấp: ");
                nhaCungCap = scanner.nextLine().trim();
                try {
                    hangHoa = new HangThucPham(maHang, tenHang, soLuong, donGia, ngaySanXuat, ngayHetHan, nhaCungCap);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
        if (hangHoa == null) {
            System.out.println("Thông tin hàng hoá nhập vào không hợp lệ");
            return false;
        }
        return them(hangHoa);
    }

    public void inThongTinToanBoHangHoa(){
        Arrays.stream(this.danhSachHangHoa, 0, this.soLuong).forEach(o -> System.out.println(o));
    }

    private int laySoChi(String maHangHoa){
        for (int i = 0; i < this.soLuong; i++) {
            if (this.danhSachHangHoa[i] == null) {
                break;
            }
            if (this.danhSachHangHoa[i].getMaHang().equals(maHangHoa)) {
                return i;
            }
        }
        return -1;
    }

    private void moRongDanhSach(){
        int newLength = (int) Math.ceil(this.danhSachHangHoa.length * 1.5);
        this.danhSachHangHoa = Arrays.copyOf(this.danhSachHangHoa, newLength);
    }
}
