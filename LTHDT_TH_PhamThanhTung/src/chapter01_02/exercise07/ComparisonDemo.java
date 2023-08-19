/*
 *  @ (#) ComparisonDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise07;

/**
 * Thao tác với các toán tử quan hệ, toán tử so sánh trong ngôn ngữ lập trình Java.
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class ComparisonDemo {
    public static void main(String[] args) {
        int value1 = 1;
        int value2 = 2;
        System.out.println("value1 == value2: " + (value1 == value2));  // 1 == 2: sai
        System.out.println("value1 != value2: " + (value1 != value2));  // 1 != 2: đúng
        System.out.println("value1 > value2: " + (value1 > value2));    // 1 > 2: sai
        System.out.println("value1 < value2: " + (value1 < value2));    // 1 < 2: đúng
        System.out.println("value1 <= value2: " + (value1 <= value2));  // 1 <= 2: đúng
        System.out.println("(value1 <= value2) && (value1 == value2): " // đúng và sai: sai
                + ((value1 <= value2) && (value1 == value2))
        );
        System.out.println("(value1 <= value2) || (value1 == value2): " // đúng hoặc sai: đúng
                + ((value1 <= value2) || (value1 == value2))
        );
    }
}
