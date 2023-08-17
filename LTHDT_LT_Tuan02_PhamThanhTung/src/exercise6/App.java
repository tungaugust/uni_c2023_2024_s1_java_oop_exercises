/*
 *  @ (#) App.java      1.0 18/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise6;

import java.util.Scanner;

/**
 * Chương trình kiểm tra một số có phải là số nguyên tố hay không.
 * @author: tungpt
 * @version: 1.0
 * @since: August 18, 2023
 */
public class App {
    /**
     * Phương thức kiểm tra số nguyên tố
     * @param n là số cần kiểm tra có phải là số nguyên tố hay không
     * @return Kết quả đúng hay sai khi n là số nguyên tố.
     */
    static boolean isPrimeNumber(int n) {
        if (n <= 1) { return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if ((n % i) == 0) { return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         * Bài 6.1. Thuật toán kiểm tra số nguyên tố.
         * Input: Số nguyên n
         * Output:
         * Bước 1: Nhập số nguyên n
         * Bước 2: Nếu n < 0 thì chương trình dừng
         * Bước 3: Nếu n = 0 hoặc n = 1 thì n không là số nguyên tố, dừng chương trình
         * Bước 4: Gán i := 2
         * Bước 5: Xét điều kiện i < sqrt(n):
         *      + Nếu điều kiện đúng thì , sau đó đến Bước 6
         *      + Nếu điều kiện sai thì n là số nguyên tố, dừng chương trình
         * Bước 6: Xét n mod i = 0:
         *      + Nếu điều kiện đúng thì n không là số nguyên tố, dừng chương trình.
         *      + Nếu điều kiện sai thì đến Bước 7
         * Bước 7: Gán i := i + 1, sau đó quay lại Bước 5
         * */

        /*
         * Bài 6.2. Chương trình tính tổng các số từ 1 đến n.
         * */
        // tạo đối tượng Scanner cho việc nhập dữ liệu từ console
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số n: ");
        int n = Integer.valueOf(scanner.nextLine().trim());
        if (n < 0) {    // chỉ xét số nguyên tố khi số đó là số tự nhiên
            System.out.printf("Số %d là số âm.\n", n);
            System.exit(0);
        }
        if (isPrimeNumber(n)) {
            System.out.printf("Số %d là số nguyên tố.\n", n);
        } else {
            System.out.printf("Số %d không là số nguyên tố.\n", n);
        }
    }
}
