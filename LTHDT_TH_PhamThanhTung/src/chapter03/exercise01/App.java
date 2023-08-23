/*
 *  @ (#) App.java      1.0 23/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise01;

import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 23, 2023
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        double chieuDai = Double.valueOf(scanner.nextLine().trim());
        System.out.print("Nhập chiều rộng: ");
        double chieuRong = Double.valueOf(scanner.nextLine().trim());
        HinhChuNhat hinhChuNhat = new HinhChuNhat();
        hinhChuNhat.setChieuDai(chieuDai);
        hinhChuNhat.setChieuRong(chieuRong);
        System.out.println(hinhChuNhat);
    }
}
