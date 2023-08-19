/*
 *  @ (#) ArithmeticDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise06;

/**
 * Thao tác với các toán tử số học
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class ArithmeticDemo {
    public static void main(String[] args) {
        int result = 1 + 2;     // result = 3
        result = result - 1;    // result = 3 - 1 = 2
        result = result * 2;    // result = 2 * 2 = 4
        result = result / 2;    // result = 4 / 2 = 2
        result = result + 8;    // result = 2 + 8 = 10
        result = result % 7;    // result = 10 % 7 = 3
        System.out.println("final result: " + result);
    }
}
