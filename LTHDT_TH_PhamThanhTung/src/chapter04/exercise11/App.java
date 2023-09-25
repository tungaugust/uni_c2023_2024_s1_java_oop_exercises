/*
 *  @ (#) App.java      1.0 20/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise11;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 20, 2023
 */
public class App {
    public static void main(String[] args) {
        DanhSachHangHoa danhSachHangHoa = new DanhSachHangHoa();
        HangHoa hangHoa1 = new HangThucPham("TP001","Thịt heo", 15, 50000.0, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 22), "CoopFood");
        HangHoa hangHoa2 = new HangThucPham("TP003","Cá hồi", 20, 120000.0, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 23), "CoopFood");
        HangHoa hangHoa3 = new HangThucPham("TP002","Rau muống", 22, 15000.0, LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 20), "CoopFood");
        HangHoa hangHoa4 = new HangSanhSu("SS003","Chén", 15, 30000.0, LocalDate.of(2023, 9, 15), LocalDate.of(2023, 9, 21));
        HangHoa hangHoa5 = new HangSanhSu("SS001","Dĩa", 5, 110000.0, LocalDate.of(2023, 9, 10), LocalDate.of(2023, 9, 21));
        HangHoa hangHoa6 = new HangSanhSu("SS002","Cốc", 50, 50000.0, LocalDate.of(2023, 9, 4), LocalDate.of(2023, 9, 21));
        HangHoa hangHoa7 = new HangDienMay("DM002","Tủ lạnh", 13, 6500000.0, 12, 60);
        HangHoa hangHoa8 = new HangDienMay("DM003","Máy giặt", 20, 10400000.0, 12, 30);
        HangHoa hangHoa9 = new HangDienMay("DM001","Máy lạnh", 10, 4400000.0, 12, 40);
        danhSachHangHoa.them(hangHoa1);
        danhSachHangHoa.them(hangHoa2);
        danhSachHangHoa.them(hangHoa3);
        danhSachHangHoa.them(hangHoa4);
        danhSachHangHoa.them(hangHoa5);
        danhSachHangHoa.them(hangHoa6);
        danhSachHangHoa.them(hangHoa7);
        danhSachHangHoa.them(hangHoa8);
        danhSachHangHoa.them(hangHoa9);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        while (flag) {
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t[ 1 ] Thêm một người vào danh sách.");
            System.out.println("\t[ 2 ] Xuất danh sách.");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 2 ]: ");

            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }

            switch (option) {
                case 1:
                    System.out.println("[ 1 ] Thêm một người vào danh sách.");
                    danhSachHangHoa.them(scanner);
                    break;
                case 2:
                    System.out.println("[ 2 ] Xuất danh sách.");
                    danhSachHangHoa.inThongTinToanBoHangHoa();
                    break;
                case 0:
                    System.out.println("[ 0 ] Thoát MENU.");
                    flag = false;
                    break;
                default: break;
            }
        }

    }
}
