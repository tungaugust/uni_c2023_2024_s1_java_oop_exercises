/*
 *  @ (#) SumNumberList.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise13;

import java.io.IOException;
import java.io.InputStream;

/**
 * Chương trình in ra tổng 1 + 2 + 3 + ... + n với n được nhập từ tham số command line
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class SumNumberList {
    public static void main(String[] args) {
        /* Cách chạy chương trình với CLI arguments
        * - Click phải vào file Java muốn chạy.
        * - Chọn More Run/Debug
        * - Chọn Modify Run Configuration...
        * - Nhập các tham số vào ô Program Arguments, rồi nhấn OK.
        * - Chạy chương trình như binh thường. Khi này, chương trình sẽ nhận các tham số đã nhập.
        * */
        int sum = 0;
        int n = Integer.valueOf(args[0].trim());
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Cho n = " + n + ", tổng 1 + 2 + 3 + ... + n = " + sum);
    }
}
