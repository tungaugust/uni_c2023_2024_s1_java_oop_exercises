/*
 *  @ (#) App.java      1.0 24/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise03b;

import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 24, 2023
 */
public class App {
    public static void main(String[] args) {
        HangThucPham hangThucPham1 = new HangThucPham("001", "Gao", 100000.0,
                LocalDate.of(2018, 7, 10),
                LocalDate.of(2018, 7, 10));
        HangThucPham hangThucPham2 = new HangThucPham("002", "Mi", 5000.0,
                LocalDate.of(2018, 3, 1),
                LocalDate.of(2018, 9, 10));
        HangThucPham hangThucPham3 = new HangThucPham("003", "Nuoc", 10000.0,
                LocalDate.of(2017, 3, 1),
                LocalDate.of(2018, 3, 1));

        String headerLine = String.format("%-15s | %-20s | %25s | %20s | %20s",
                "Mã hàng", "Tên hàng", "Đơn giá", "Ngày sản xuất", "Ngày hết hạn"
        );
        System.out.println(headerLine);
        String lineSymbol = "=";
        for (int i = 0; i < headerLine.length(); i++) {
            System.out.print(lineSymbol);
        }
        System.out.println();

        System.out.println(hangThucPham1);
        System.out.println(hangThucPham2);
        System.out.println(hangThucPham3);

    }
}
