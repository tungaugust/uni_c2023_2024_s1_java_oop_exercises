/*
 *  @ (#) App.java      1.0 17/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise4;

import java.util.Scanner;

/**
 * Chương trình tính tiền điện.
 * @author: tungpt
 * @version: 1.0
 * @since: August 17, 2023
 */
public class App {
    public static void main(String[] args) {
        /*
         * Bài 4.1. Thuật toán tính tiền điện phải trả trong một tháng.
         * Input:
         *      + Số điện năng tháng trước (số cũ) oldQuantity
         *      + số điện năng hiện tại (số mới) newQuantity
         * Output: Tiền điện phải trả amount
         * Bước 1: Tính lượng điện đã tiêu thụ consumedQuantity = newQuantity - oldQuantity
         * Bước 2: Khi consumedQuantity < 0 thì chương trình dừng
         * Bước 3: Khi consumedQuantity >= 0, gán amount := 0.0, gán biến số lượng điện theo bậc levelQuantity := 0
         * Bước 4: Gán i := 0
         * Bước 5: Xét điều kiện i < 6:
         *      + Nếu điều kiện đúng thì đến Bước 6
         *      + Nếu điều kiện sai thì đến Bước 8
         * Bước 6: Xét từng chì số i tương ứng với từng bậc lượng điện tiêu thụ
         *      + Khi i = 0 (bậc 1):
         *          Nếu consumedQuantity > 50 thì gán levelQuantity := 50 và giảm consumedQuantity đi 50,
         *              ngược lại thì gán levelQuantity := consumedQuantity và consumedQuantity := 0.
         *          amount := amount + levelQuantity * 1.678
         *      + Khi i = 1 (bậc 2):
         *          Nếu consumedQuantity > 50 thì gán levelQuantity := 50 và giảm consumedQuantity đi 50,
         *              ngược lại thì gán levelQuantity := consumedQuantity và consumedQuantity := 0.
         *          amount := amount + levelQuantity * 1.734
         *      + Khi i = 2 (bậc 3):
         *          Nếu consumedQuantity > 100 thì gán levelQuantity := 50 và giảm consumedQuantity đi 100,
         *              ngược lại thì gán levelQuantity := consumedQuantity và consumedQuantity := 0.
         *          amount := amount + levelQuantity * 2.014
         *      + Khi i = 3 (bậc 4):
         *          Nếu consumedQuantity > 100 thì gán levelQuantity := 50 và giảm consumedQuantity đi 100,
         *              ngược lại thì gán levelQuantity := consumedQuantity và consumedQuantity := 0.
         *          amount := amount + levelQuantity * 2.536
         *      + Khi i = 4 (bậc 5):
         *          Nếu consumedQuantity > 100 thì gán levelQuantity := 50 và giảm consumedQuantity đi 100,
         *              ngược lại thì gán levelQuantity := consumedQuantity và consumedQuantity := 0.
         *          amount := amount + levelQuantity * 2.834
         *      + Khi i = 5 (bậc 6):
         *          levelQuantity := consumedQuantity và consumedQuantity := 0.
         *          amount := amount + levelQuantity * 2.927
         * Bước 7: Gán i := i + 1, sau đó quay lại Bước 5
         * Bước 8: In ra kết quả amount
         * */

        /*
         * Bài 4.2. Chương trình tiền điện phải trả trong một tháng.
         * */
        // tạo đối tượng Scanner cho việc nhập dữ liệu từ console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chỉ số điện tháng trước và tháng này.");
        System.out.print("Chỉ số điện tháng trước: ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        int oldQuantity = Integer.valueOf(scanner.nextLine().trim());
        System.out.print("Chỉ số điện tháng này: ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        int newQuantity = Integer.valueOf(scanner.nextLine().trim());

        int consumedQuantity = newQuantity - oldQuantity;
        int originConsumedQuantity = consumedQuantity;
        if (consumedQuantity < 0) {
            System.out.println("Không thể tính lượng điện đã tiêu thụ.");
            System.exit(0);
        }

        int levelQuantity = 0;
        double amount = 0.0;

        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0: // 0-50: tiền đối đa = 83.9
                    if (consumedQuantity > 50) {
                        levelQuantity = 50;
                        consumedQuantity -= 50;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 1.678;
                    break;
                case 1: // 51-100: tiền đối đa = 86.7
                    if (consumedQuantity > 50) {
                        levelQuantity = 50;
                        consumedQuantity -= 50;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 1.734;
                    break;
                case 2: // 101-200: tiền đối đa = 201.4
                    if (consumedQuantity > 100) {
                        levelQuantity = 100;
                        consumedQuantity -= 100;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 2.014;
                    break;
                case 3: // 201-300: tiền đối đa = 253.6
                    if (consumedQuantity > 100) {
                        levelQuantity = 100;
                        consumedQuantity -= 100;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 2.536;
                    break;
                case 4: // 301-400: tiền đối đa = 283.4
                    if (consumedQuantity > 100) {
                        levelQuantity = 100;
                        consumedQuantity -= 100;
                    } else {
                        levelQuantity = consumedQuantity;
                        consumedQuantity = 0;
                    }
                    amount += (double) levelQuantity * 2.834;
                    break;
                case 5: // 401+
                    levelQuantity = consumedQuantity;
                    consumedQuantity = 0;
                    amount += (double) levelQuantity * 2.927;
                    break;
                default: break;
            }
        }

        System.out.printf("Tiền điện phải trả cho %d số điện là %.3f nghìn VND.\n", originConsumedQuantity, amount);
    }

}
