/*
 *  @ (#) SumMultiplesOf7.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise12;

/**
 * Chương trình xuất ra tổng các số là bội số của 7 (từ 1 đến 100).
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class SumMultiplesOf7 {
    public static void main(String[] args) {
        int sum = 0;
        int multiple7 = 7;
        while ((multiple7 >=1) && (multiple7 <= 100)) {
            sum += multiple7;
            multiple7 += 7;
        }
        System.out.println("Tổng các số là bội số của 7 (từ 1 đến 100): " + sum);
    }
}
