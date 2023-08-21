/*
 *  @ (#) PrintShapesVersion2.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise29;

import java.util.Scanner;

/**
 * chương trình in ra hình
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class PrintShapesVersion2 {
    public static void main(String[] args) {
        String EXISTENCE = "* ";      // asterisk
        String NONEXISTENCE = "  ";   // blank
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài cạnh: ");
        int side = Integer.valueOf(scanner.nextLine().trim());
        int center = (side - 1) / 2;
        int parity = 1;  // lẻ
        if (side % 2 == 0) {
            parity = 2; // chẵn
        }

        System.out.println("Hình a. Hình tam giác vuông có chiều dài cạnh góc vuông là " + side + ".");
    }
}
