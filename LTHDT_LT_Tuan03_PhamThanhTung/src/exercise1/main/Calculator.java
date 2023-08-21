/*
 *  @ (#) Calculator.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise1.main;

/**
 * Lớp Calculator dùng cho Unit Test
 * Tại phần tên lớp, nhấn tổ hợp phím Alt+Enter, chọn Create Test để tạo UnitTest
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class Calculator {

    /**
     * Tính tổng của dãy số nguyên.
     * @param numbers: danh sách số nguyên
     * @return tổng của dãy số nguyên numbers
     */
    public static int sum(int... numbers) {
        int total = 0;
        for (int number: numbers) {
            total += number;
        }
        return total;
    }

    /**
     * Tính thương của phép chia hai số.
     * @param a: số bị chia
     * @param b: số chia
     * @return thương của phép chia a/b
     * @throws ném ra ngoại lệ ArithmeticException nếu tham số b = 0
     */
    public static float div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return (float) a / b;
    }

}
