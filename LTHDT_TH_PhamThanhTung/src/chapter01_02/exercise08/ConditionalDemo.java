/*
 *  @ (#) ConditionalDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise08;

/**
 * Thao tác với toán tử điều kiện
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class ConditionalDemo {
    public static void main(String[] args) {
        int value1 = 1;
        int value2 = 2;
        int result;
        boolean someCondition = true;
        result = someCondition ? value1 : value2;
        System.out.println(result); // 1
    }
}
