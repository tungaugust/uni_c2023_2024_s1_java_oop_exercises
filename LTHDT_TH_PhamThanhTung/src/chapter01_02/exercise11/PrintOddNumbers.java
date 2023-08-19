/*
 *  @ (#) PrintOddNumbers.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise11;

/**
 * Chương trình in ra những số lẻ từ 1 đến 99.
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class PrintOddNumbers {
    public static void main(String[] args) {
        for (int i = 1; i <= 99 ; i++) {
            if ((i % 2) != 0) {
                System.out.print(i + " ");
            }
        }
    }
}
