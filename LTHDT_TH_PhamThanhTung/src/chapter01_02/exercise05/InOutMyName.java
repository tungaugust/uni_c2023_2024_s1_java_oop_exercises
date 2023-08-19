/*
 *  @ (#) InOutMyName.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise05;

import java.util.Scanner;

/**
 * Chương trình nhập vào tên của mình và xuất ra màn hình “Hello + Tên”
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class InOutMyName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine().trim();
        System.out.println("Tên đã nhập vào là " + name + ".");
    }
}
