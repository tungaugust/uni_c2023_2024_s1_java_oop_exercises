/*
 *  @ (#) App.java      1.0 18/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise7;

import java.util.ArrayList;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 18, 2023
 */
public class App {
    static double averageTwoInt(int a, int b) {
        return (double) (a + b) / 2;
    }

    static double averageThreeInt(int a, int b, int c) {
        return (double) (a + b + c) / 3;
    }

    /**
     *
     * @param integers
     * @return
     */
    static double averageIntegers(int... integers) {
        int sum = 0;
        for (int i: integers) {
            sum += i;
        }
        return (double) sum / integers.length;
    }
    public static void main(String[] args) {
        // Truyền tham số xác định (cố định)
        System.out.println(averageTwoInt(1, 2));
        System.out.println(averageThreeInt(1, 2, 3));

        // Truyền tham số tuỳ biến (không cố định): variable arguments.
        // - Có thể truyền vào một danh sách đối số kiểu dữ liệu tương ứng
        System.out.println(averageIntegers(1, 2, 3, 4, 5, 6));
        // - Có thể truyền vào một mảng với kiểu dữ liệu tương ứng
        System.out.println(averageIntegers(new int[] {1, 2, 3, 4, 5, 6}));
        /* Debug:
        - Truyền danh sách đối số 1, 2, 3, 4, 5, 6 cho phương thức averageIntegers()
        - Các đối số trên là các phần tử trong mảng:
            integers = {1, 2, 3, 4, 5, 6}
        - Gán sum := 0
        - Sử dụng lặp foreach để lấy từng phần tử trong mảng integers
            + Lặp 0: i = 1; sum = sum + i = 0 + 1 = 1
            + Lặp 1: i = 2; sum = sum + i = 1 + 2 = 3
            + Lặp 2: i = 3; sum = sum + i = 3 + 3 = 6
            + Lặp 3: i = 4; sum = sum + i = 6 + 4 = 10
            + Lặp 4: i = 5; sum = sum + i = 10 + 5 = 15
            + Lặp 5: i = 6; sum = sum + i = 15 + 6 = 21
            + Không còn phần tử, kết thúc vòng lặp foreach
        - Trả về kết quả của biểu thức:
            (double) sum / integers.length
            = (double) 21 / 6           # thay các biến trong biểu thành các giá trị
            = 21.0 / 6                  # ép kiểu số 21 kiểu int thành 21.0 kiểu double
            = 3.5
        */
    }
}
