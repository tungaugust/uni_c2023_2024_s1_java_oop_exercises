/*
 *  @ (#) SumEvenOddNumberList.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise14;

/**
 * Viết chương trình in ra tổng 1 + 3 + 5 + ... + n nếu n là số chẵn
 * và 2 + 4 + 6 + ... + n nếu n là số lẻ. Giá trị n được nhập vào từ tham số command line
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class SumEvenOddNumberList {
    public static void main(String[] args) {
        /* Cách chạy chương trình với CLI arguments
         * - Click phải vào file Java muốn chạy.
         * - Chọn More Run/Debug
         * - Chọn Modify Run Configuration...
         * - Nhập các tham số vào ô Program Arguments, rồi nhấn OK.
         * - Chạy chương trình như binh thường. Khi này, chương trình sẽ nhận các tham số đã nhập.
         * */

        int sum = 0;
        int startNumber = 1;

        int n = Integer.valueOf(args[0].trim());
        if ((n % 2) == 0) {
            startNumber = 2;
        }

        for (int i = startNumber; i <= n; i += 2) {
            System.out.print(i + " ");
            sum += i;
        }
        if (startNumber == 1) {
            System.out.println("Cho n = " + n + ", tổng 1 + 3 + 5 + ... + n = " + sum);
        } else {
            System.out.println("Cho n = " + n + ", tổng 2 + 4 + 6 + ... + n = " + sum);
        }
    }
}
