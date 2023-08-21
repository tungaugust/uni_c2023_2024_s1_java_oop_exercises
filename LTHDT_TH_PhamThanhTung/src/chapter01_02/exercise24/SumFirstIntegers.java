/*
 *  @ (#) SumFirstIntegers.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise24;

import java.util.Scanner;

/**
 * Chương trình tính tổng các số nguyên tố nhỏ hơn N
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class SumFirstIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số số nguyên: ");
        int n = Integer.valueOf(scanner.nextLine().trim());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Tổng " + n +" số nguyên (dương) đầu tiên: " + sum);
    }
}
