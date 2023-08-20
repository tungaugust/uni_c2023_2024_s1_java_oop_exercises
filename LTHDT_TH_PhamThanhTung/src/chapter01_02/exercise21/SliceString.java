/*
 *  @ (#) SliceString.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise21;

/**
 * hàm tách chuỗi gốc thành chuỗi khác
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class SliceString {
    public static void main(String[] args) {
        String s = "\"Bai Tap Mon Lap Trinh Java\"";
        String[] a = s.split(" ");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
