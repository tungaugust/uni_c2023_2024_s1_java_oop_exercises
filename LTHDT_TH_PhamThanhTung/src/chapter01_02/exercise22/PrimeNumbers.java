/*
 *  @ (#) PrimeNumbers.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise22;

import java.util.Scanner;

/**
 * Chương trình kiểm tra số nhập vào có phải là số nguyên tố hay không
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        /*
         * - Số nguyên tố (prime number) là số tự nhiên có ước số là 1 và chính nó.
         * - Số nửa nguyên tố (semi-prime, biprime) là số tự nhiên được tạo thành từ tích của hai số nguyên tố
         * (hai số giống nhau hoặc phân biệt).
         * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tự nhiên: ");
        int number = Integer.valueOf(scanner.nextLine().trim());
        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if ((number % i) == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime) {
            System.out.println("Số " + number + " là số nguyên tố.");
        } else {
            System.out.println("Số " + number + " không là số nguyên tố.");
        }
    }
}
