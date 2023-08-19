/*
 *  @ (#) PrePostDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise06;

/**
 * Thao tác với toán tử pre-increment, post-increment, pre-decrement và post-decrement
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class PrePostDemo {
    public static void main(String[] args) {
        int i = 3;  // i = 3
        i++;    // i = 3 + 1 = 4
        System.out.println(i);  // in ra 4
        ++i;    // i = 4 + 1 = 5
        System.out.println(i);  // in ra 5
        System.out.println(++i);    // i = 5 + 1 = 6; in ra 6
        System.out.println(i++);    // i = 6; in ra 6; i = 6 + 1 = 7
        System.out.println(--i);    // i = 7 - 1 = 6; in ra 6
        System.out.println(i--);    // i = 6; in ra 6; i = 6 - 1 = 5
        System.out.println(i);  // in ra 5
    }
}
