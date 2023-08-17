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
         * Bước 2: Xét consumedQuantity để chọn đơn giá unitPrice theo từng mức tương ứng:
         *      + Nếu 0 <= consumedQuantity <= 50 thì unitPrice = 1.678
         *      + Nếu 51 <= consumedQuantity <= 100 thì unitPrice = 1.734
         *      + Nếu 101 <= consumedQuantity <= 200 thì unitPrice = 2.014
         *      + Nếu 201 <= consumedQuantity <= 300 thì unitPrice = 2.536
         *      + Nếu 301 <= consumedQuantity <= 400 thì unitPrice = 2.834
         *      + Nếu consumedQuantity >= 401 thì unitPrice = 2.927
         *      + Nếu consumedQuantity < 0 thì unitPrice = -1
         * Bước 3: Xét unitPrice:
         *      + Nếu unitPrice < 0 thì in ra thông báo "Không thể tính tiền điện!".
         *      + Nếu unitPrice >= 0 thì tính tiền điện theo công thức: amount = consumedQuantity * unitPrice
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

        // bước 1: Tính lượng điện đã tiêu thụ
        int consumedQuantity = newQuantity - oldQuantity;
        // bước 2: Xét consumedQuantity để chọn đơn giá unitPrice theo từng mức tương ứng bằng câu lệnh if
        double unitPrice;
        if ((consumedQuantity >= 0) && (consumedQuantity <= 50)) {
            unitPrice = 1.678;
        } else if ((consumedQuantity >= 51) && (consumedQuantity <= 100)) {
            unitPrice = 1.734;
        } else if ((consumedQuantity >= 101) && (consumedQuantity <= 200)) {
            unitPrice = 2.014;
        } else if ((consumedQuantity >= 201) && (consumedQuantity <= 300)) {
            unitPrice = 2.536;
        } else if ((consumedQuantity >= 301) && (consumedQuantity <= 400)) {
            unitPrice = 2.834;
        } else if (consumedQuantity >= 401) {
            unitPrice = 2.927;
        } else {
            unitPrice = -1;
        }
        // bước 3: Xét unitPrice
        if (unitPrice < 0) {
            System.out.println("Không thể tính tiền điện!");
        } else {
            double amount = consumedQuantity * unitPrice;
            System.out.printf("Tiền điện phải trả cho %d số điện là %.3f VND.\n", consumedQuantity, amount);
        }
    }
}
