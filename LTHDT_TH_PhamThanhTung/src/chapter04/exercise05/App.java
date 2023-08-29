/*
 *  @ (#) App.java      1.0 29/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise05;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * chương trình quản lý các chuyến xe
 * @author: tungpt
 * @version: 1.0
 * @since: August 29, 2023
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ChuyenXe> chuyenXeList = new ArrayList<>();

        ChuyenXe chuyenXe1 = new ChuyenNoiThanh("XE001", "Trần Long", "77B-777.77", 50000000.0, "10", 100);
        ChuyenXe chuyenXe2 = new ChuyenNoiThanh("XE002", "Triệu Lân", "99B-999.99", 45000000.0, "20", 90);
        ChuyenXe chuyenXe3 = new ChuyenNoiThanh("XE003", "Võ Phụng", "88B-888.88", 30000000.0, "15", 50);
        ChuyenXe chuyenXe4 = new ChuyenNoiThanh("XE004", "Dương Quy", "55B-555.55", 60000000.0, "30", 120);
        ChuyenXe chuyenXe5 = new ChuyenNgoaiThanh("XE005", "La Nhất", "63B-963.01", 40000000.0, "Tiền Giang", 1);
        ChuyenXe chuyenXe6 = new ChuyenNgoaiThanh("XE006", "Hoàng Nhị", "63B-963.02", 80000000.0, "An Giang", 2);
        ChuyenXe chuyenXe7 = new ChuyenNgoaiThanh("XE007", "Trương Tam", "63B-963.03", 45000000.0, "Trà Vinh", 1);
        ChuyenXe chuyenXe8 = new ChuyenNgoaiThanh("XE008", "Lý Tứ", "63B-963.04", 100000000.0, "Cà Mau", 3);

        chuyenXeList.add(chuyenXe1);
        chuyenXeList.add(chuyenXe2);
        chuyenXeList.add(chuyenXe3);
        chuyenXeList.add(chuyenXe4);
        chuyenXeList.add(chuyenXe5);
        chuyenXeList.add(chuyenXe6);
        chuyenXeList.add(chuyenXe7);
        chuyenXeList.add(chuyenXe8);

        // Nhập chuyến xe
        ChuyenXe chuyenXe = null;
        String input;
        String loaiXe;
        String maSoChuyen;
        String tenTaiXe;
        String soXe;
        double doanhThu;
        String soTuyen = "";
        int quangDuong = 0;
        String noiDen = "";
        int soNgay = 0;

        System.out.print(">>> Nhập số 1 nếu muốn nhập loại chuyến xe nội thành (mặc định bỏ trống là loại chuyến xe ngoại thành): ");
        input = scanner.nextLine().trim();
        if (input.equals("1")) {
            loaiXe = ChuyenXe.NOI_THANH;
        } else {
            loaiXe = ChuyenXe.NGOAI_THANH;
        }
        System.out.print(">>> Nhập mã số chuyến: ");
        maSoChuyen = scanner.nextLine().trim();
        System.out.print(">>> Nhập họ tên tài xế: ");
        tenTaiXe = scanner.nextLine().trim();
        System.out.print(">>> Nhập biển số xe: ");
        soXe = scanner.nextLine().trim();
        if (loaiXe.equals(ChuyenXe.NOI_THANH)) {
            System.out.print(">>> Nhập số tuyến: ");
            soTuyen = scanner.nextLine().trim();
            System.out.print(">>> Nhập số km đi được: ");
            input = scanner.nextLine().trim();
            try {
                quangDuong = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                quangDuong = 0;
            }
        } else {
            System.out.print(">>> Nhập điểm đến: ");
            soTuyen = scanner.nextLine().trim();
            System.out.print(">>> Nhập số ngày đi được: ");
            input = scanner.nextLine().trim();
            try {
                soNgay = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                soNgay = 0;
            }
        }
        System.out.print(">>> Nhập doanh thu: ");
        input = scanner.nextLine().trim();
        try {
            doanhThu = Double.valueOf(input);
        } catch (NumberFormatException e) {
            doanhThu = 0.0;
        }
        try {
            if (loaiXe.equals(ChuyenXe.NOI_THANH)) {
                chuyenXe = new ChuyenNoiThanh(maSoChuyen, tenTaiXe, soXe, doanhThu, soTuyen, quangDuong);
            } else {
                chuyenXe = new ChuyenNgoaiThanh(maSoChuyen, tenTaiXe, soXe, doanhThu, noiDen, soNgay);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        chuyenXeList.add(chuyenXe);

        // Xuất danh sách các chuyến xe
        double doanhThuNoiThanh = 0.0;
        double doanhThuNgoaiThanh = 0.0;
        System.out.println("\nDanh sách các chuyến xe");
        for (ChuyenXe chuyen: chuyenXeList) {
            if (chuyen instanceof ChuyenNoiThanh) {
                chuyen = (ChuyenNoiThanh) chuyen;
                System.out.println("Chuyến nội thành: " + chuyen);
                doanhThuNoiThanh += chuyen.getDoanhThu();
            }
            if (chuyen instanceof ChuyenNgoaiThanh) {
                chuyen = (ChuyenNgoaiThanh) chuyen;
                System.out.println("Chuyến ngoại thành: " + chuyen);
                doanhThuNgoaiThanh += chuyen.getDoanhThu();
            }
        }

        // Tính tổng doanh thu cho từng loại xe
        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
        System.out.println("\nTổng doanh thu của các chuyến xe nội thành: " + decimalFormat.format(doanhThuNoiThanh));
        System.out.println("\nTổng doanh thu của các chuyến xe ngoại thành: " + decimalFormat.format(doanhThuNgoaiThanh));
    }
}
