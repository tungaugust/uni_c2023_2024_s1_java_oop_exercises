/*
 *  @ (#) CountDigitsInString.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise20;

import java.util.Scanner;

/**
 * Hàm để đếm số lượng ký tự là số có trong chuỗi s
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class CountDigitsInString {
    static int countDigits(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi kí tự: ");
        String s = scanner.nextLine();
        System.out.println("Số kí tự là chữ số có trong chuỗi đã nhập là " + countDigits(s) + " kí tự.");
    }
}
