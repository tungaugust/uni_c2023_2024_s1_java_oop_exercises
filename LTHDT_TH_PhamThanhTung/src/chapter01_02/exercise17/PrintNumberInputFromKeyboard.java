/*
 *  @ (#) PrintNumberInputFromKeyboard.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise17;

import java.util.Scanner;

/**
 * Chương trình đọc một giá trị nguyên từ bàn phím và in ra số đó là số chẵn, lẻ hoặc zero
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class PrintNumberInputFromKeyboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên từ bàn phím: ");
        int number = Integer.valueOf(scanner.nextLine().trim());
        if (number == 0) {
            System.out.println("Số " + number + " là zero.");
        } else {
            if ((number % 2) == 0) {
                System.out.println("Số " + number + " là số chẵn.");
            } else {
                System.out.println("Số " + number + " là số lẻ.");
            }
        }
    }
}
