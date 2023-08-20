/*
 *  @ (#) GreatestCommonDivisorOfTwoNumbers.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise23;

import java.util.Scanner;

/**
 * Chương trình tìm ước số chương lớn nhất của hai số.
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class GreatestCommonDivisorOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập hai số tự nhiên cách nhau bằng dấu cách: ");
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();

        /* Cách 1: Thuật toán Euclid:
         * Để tính ước chung lớn nhất của hai số nguyên dương bằng cách thay số lớn hơn bằng hiệu của các số
         * và lặp lại điều này cho đến khi hai số bằng nhau, đó là ước chung lớn nhất.
         * Với a > b, GCD(a, b) = GCD(a - b, b)
         */
        int a = firstNumber;
        int b = secondNumber;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        System.out.println("Thuật toán Euclid: Ươc số chương lớn nhất của " + firstNumber + " và " + secondNumber + " là " + a);

        /* Cách 2: Thuật toán Euclidean:
         * Là một biến thể của thuật toán Euclid, thay số lớn bằng phần dư của phép chia của các số
         * và lặp lại điều này cho đến khi phần dư bằng 0, số nhỏ hơn là ước chung lớn nhất.
         * GCD(a, b) = GCD(b, a mod b)
         * GCD(a, 0) = a, a là ước chung lớn nhất
         */
        a = firstNumber;
        b = secondNumber;
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println("Thuật toán Euclidean: Ươc số chương lớn nhất của " + firstNumber + " và " + secondNumber + " là " + a);
    }
}
