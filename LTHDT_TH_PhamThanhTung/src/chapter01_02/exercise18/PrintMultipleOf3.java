/*
 *  @ (#) PrintMultipleOf3.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise18;

/**
 * Chương trình in ra bội số của 3 từ 300 đến 3
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class PrintMultipleOf3 {
    public static void main(String[] args) {
        System.out.println("Bội số của 3 từ 300 đến 3:");
        for (int i = 300; i >= 3; i--) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
