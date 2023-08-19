/*
 *  @ (#) UnaryDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise06;

/**
 * Thao tác với toán tử 1 ngôi
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class UnaryDemo {
    public static void main(String[] args) {
        int result = +1;    // Gán result := 1
        System.out.println(result); // 1

        result--;   // Giảm giá trị của biến result đi 1 và gán kết quả đó cho biến result sau dòng lệnh
        System.out.println(result); // 0

        result++;   // Tăng giá trị của biến result lên 1 và gán kết quả đó cho biến result sau dòng lệnh
        System.out.println(result); // 1

        result = -result;   // Đổi dấu giá trị của result và gán kết quả đó cho biến result
        System.out.println(result); // -1

        boolean success = false;
        System.out.println(success);    // false
        System.out.println(!success);   // true
    }
}
