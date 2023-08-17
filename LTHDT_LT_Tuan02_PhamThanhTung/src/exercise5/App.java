/*
 *  @ (#) App.java      1.0 17/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise5;

import java.util.Scanner;

/**
 * Chương trình tính tổng các số từ 1 đến n.
 * @author: tungpt
 * @version: 1.0
 * @since: August 17, 2023
 */
public class App {
    public static void main(String[] args) {
        /*
         * Bài 5.1. Thuật toán tính tổng các số từ 1 đến n.
         * Input: Số nguyên n.
         * Output: Tổng các số từ 1 đến n.
         * Bước 1: Nhập số nguyên n
         * Bước 2: Khi n <= 0 thì chương trình dừng
         * Bước 3: Khi n > 0, gán sum := 0
         * Bước 4: Gán i := 1
         * Bước 5: Xét điều kiện i <= n:
         *      + Nếu điều kiện đúng thì gán sum := sum + i, sau đó đến Bước 6
         *      + Nếu điều kiện sai thì đến Bước 7
         * Bước 6: Gán i := i + 1, sau đó quay lại Bước 5
         * Bước 7: In ra giá trị của biến sum (kết quả) và quay lại Bước 1.
         * */

        /*
         * Bài 5.2. Chương trình tính tổng các số từ 1 đến n.
         * */
        // tạo đối tượng Scanner cho việc nhập dữ liệu từ console
        Scanner scanner = new Scanner(System.in);
        int sum;
        int n;

        n = Integer.valueOf(scanner.nextLine().trim());
        while (n > 0) {
            sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.printf("Tổng các số từ 1 đến n = %d là %d\n\n", n, sum);
            System.out.print("Nhập số nguyên n = ");
            n = Integer.valueOf(scanner.nextLine().trim());
        }
    }
}
