/*
 *  @ (#) WhileDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise09;

/**
 * Chương trình in ra các số từ 1 đến 10.
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class WhileDemo {
    public static void main(String[] args) {
        int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
    }
}
