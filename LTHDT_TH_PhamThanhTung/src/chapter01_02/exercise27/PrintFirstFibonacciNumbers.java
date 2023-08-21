/*
 *  @ (#) PrintFirstFibonacciNumbers.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise27;

import java.util.Scanner;

/**
 * Chương trình xuất ra màn hình n số đầu tiên của chuỗi Fibonaci (có hai giá trị đầu là 1 và 1)
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class PrintFirstFibonacciNumbers {
    public static void main(String[] args) {
        /*
        * - Dãy Fibonacci là dãy vô hạn các số tự nhiên bắt đầu bằng hai phần tử 0 hoặc 1 và 1,
        * các phần tử sau đó được thiết lập theo quy tắc: mỗi phần tử luôn bằng tổng hai phần tử trước nó.
        * - Công thức truy hồi:
        *   + F(n) = 1                  khi n = 1 hoặc n = 2
        *   + F(n) = F(n-1) + F(n-2)    khi n > 2
        * */

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số số đầu tiên trong dãy Fibonacci: ");
        int n = Integer.valueOf(scanner.nextLine().trim());
        if (n <= 0) {
            System.out.println("Cần nhập số nguyên dương.");
            System.exit(0);
        }
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        if (n > 1) {
            fibonacci[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        System.out.println("Dãy Fibonacci có " + n + " số:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println();
        // Ví dụ: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, ...
    }
}
