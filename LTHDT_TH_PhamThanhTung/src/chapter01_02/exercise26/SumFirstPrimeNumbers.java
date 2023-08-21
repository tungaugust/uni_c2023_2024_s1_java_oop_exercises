/*
 *  @ (#) SumFirstPrimeNumbers.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise26;

import java.util.Scanner;

/**
 * Chương trình tính tổng N số nguyên tố đầu tiên
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class SumFirstPrimeNumbers {
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số số nguyên tố đầu tiên: ");
        int n = Integer.valueOf(scanner.nextLine().trim());
        int sum = 0;
        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                sum += number;
                count++;
            }
            number++;
        }
        System.out.println("Tổng " + n + " số nguyên tố đầu tiên: " + sum);
    }
}
