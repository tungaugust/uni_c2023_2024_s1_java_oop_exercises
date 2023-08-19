/*
 *  @ (#) PrintMaxMinValue.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise15;

/**
 * Chương trình in ra giá trị lớn nhất và nhỏ nhất trong một dãy các giá trị user đã nhập vào từ tham số command line.
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class PrintMaxMinValue {
    public static void main(String[] args) {
        // 8 6 9 123 109 21 50 130 12
        int min, max, tmp;
        if (args.length <= 0 ) {
            System.out.println("Không có danh sách truyền vào.");
            System.exit(0);
        }
        min = Integer.valueOf(args[0].trim());
        max = Integer.valueOf(args[0].trim());
        for (int i = 0; i < args.length - 1; i++) {
            tmp =Integer.valueOf(args[i+1].trim());
            if (max < tmp) {
                max = tmp;
            }
            if (min > tmp) {
                min = tmp;
            }
        }
        System.out.println("Max: " + max + "\nMin: " + min);
    }
}
