/*
 *  @ (#) ConcatenationDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise06;

/**
 * Thao tác với toán tử nối chuỗi
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class ConcatenationDemo {
    public static void main(String[] args) {
        String firstString = "This is";
        String secondString = " a concatenated string.";
        String thirdString = firstString + secondString;
        System.out.println(thirdString);
    }
}
