/*
 *  @ (#) SumPrimeNumbers.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise25;

import java.util.Scanner;

/**
 * Chương trình tính tổng các số nguyên tố nhỏ hơn N
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class SumPrimeNumbers {
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
        System.out.print("Nhập một số tự nhiên: ");
        int n = Integer.valueOf(scanner.nextLine().trim());
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        System.out.println("Tổng các số nguyên tố nhỏ hơn " + n + ": " + sum);
    }
}
