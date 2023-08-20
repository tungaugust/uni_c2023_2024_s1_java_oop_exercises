/*
 *  @ (#) CountCharacterInString.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise19;

/**
 * Chương trình in ra số lần kí tự ‘a’ xuất hiện trong một chuỗi.
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class CountCharacterInString {
    public static void main(String[] args) {
        char c = 'a';
        String s = "Java String";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Số lần kí tự \'" + c + "\' xuất hiện trong chuỗi \"" + s + "\" là " + count);
    }
}
