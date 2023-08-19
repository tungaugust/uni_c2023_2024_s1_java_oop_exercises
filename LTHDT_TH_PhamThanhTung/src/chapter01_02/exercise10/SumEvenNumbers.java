/*
 *  @ (#) SumEvenNumbers.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise10;

/**
 * Chương trình tính tổng của 10 số chẵn (even number) đầu tiên
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class SumEvenNumbers {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i * 2; // i*2 là bội số cùa 2 (multiples of 2)
        }
        System.out.println("Tổng của 10 số chẵn (even number) đầu tiên: " + sum);
    }
}
