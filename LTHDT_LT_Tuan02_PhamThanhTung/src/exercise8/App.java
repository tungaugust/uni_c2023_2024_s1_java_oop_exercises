/*
 *  @ (#) App.java      1.0 18/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise8;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 18, 2023
 */
public class App {

    static void exercise8R113Method(){
        double balance = 10000.0;
        double interestRate = 0.06;
        double withdrawAmount = 500.0;
        double interestAmount;
        int monthCount = 0;
        while (balance > 0) {
            interestAmount = balance * interestRate / 12;   // tiền lãi hàng tháng
            balance = balance + interestAmount - withdrawAmount;    // số dư sau mỗi tháng
            monthCount++;
        }
        int yearCount = Double.valueOf(Math.ceil((double) monthCount/12)).intValue();
        System.out.printf("Bài 8 - R1.13: số năm tài khoản không thể rút tiền được nữa là %d năm.\n", yearCount);
    }

    static void exercise8R114Method(double balance, double interestRate, double withdrawAmount){
        double interestAmount;
        int monthCount = 0;
        int compareDouble = Double.compare(balance * interestRate / 12, withdrawAmount);
        if (compareDouble >= 0) {
            System.out.println("Bài 8 - R1.14: The infinite amount of money.");
            return;
        }
        while (balance > 0) {
            interestAmount = balance * interestRate / 12;   // tiền lãi hàng tháng
            balance = balance + interestAmount - withdrawAmount;    // số dư sau mỗi tháng
            monthCount++;
        }
        int yearCount = Double.valueOf(Math.ceil((double) monthCount/12)).intValue();
        System.out.printf("Bài 8 - R1.14: số năm tài khoản không thể rút tiền được nữa là %d năm.\n", yearCount);
    }

    static void exercise8E14Method(double initialBalance, double interestRate, int yearCount){
        double balance = initialBalance;
        double interestAmount;
        for (int i = 0; i < yearCount; i++) {
            interestAmount = balance * interestRate;
            balance = balance + interestAmount;
        }
        System.out.printf(
                "Bài 8 - E1.4: Sau %d năm, số dư của một tại khoản có "
                + "số dư ban đầu %.2f USD với lãi suất %.2f%%/năm là %.2f USD.\n"
                , yearCount
                , initialBalance
                , interestRate * 100
                , balance
        );
    }

    public static void main(String[] args) {
        /*
         * Bài 8 - R1.13. Thuật toán
         * Input:
         *      + Số dư ban đầu balance = 10000 (USD)
         *      + Lãi suất một năm interestRate = 0.06
         *      + Số tiền rút hàng tháng withdrawAmount = 500 (USD)
         * Output:
         *      + Số năm mà tài khoản cạn tiền, không thể rút withdrawAmount được nữa
         * Bước 1: Nhập các tham số balance, interestRate, withdrawAmount
         * Bước 2: Đặt monthCount là số tháng rút được số tiền withdrawAmount, gán monthCount := 0
         * Bước 3: Xét balance:
         *      + Nếu balance > 0 thì tiếp tục đến bước 4
         *      + Nếu balance <= 0 thì nhảy đến bước 7
         * Bước 4: Tính tiền lãi interestAmount := balance * interestRate / 12
         * Bước 5: Tính lại số dư sau khi đã rút withdrawAmount: balance := balance + interestAmount - withdrawAmount
         * Bước 6: Tăng biến monthCount lên 1 đơn vị, và quay lại bước 3
         * Bước 7: Tính số năm tài khoản không thể rút tiền được nữa với biểu thức: monthCount / 12 (kết quả làm tròn lên)
         * */
        exercise8R113Method();

        /*
         * Bài 8 - R1.14.
         * Xét thuật toán R1.13, thuật toán sẽ không dừng khi số tiền lãi hàng tháng >= số tiền đã rút hàng tháng.
         * Input:
         *      + Số dư ban đầu balance
         *      + Lãi suất một năm interestRate
         *      + Số tiền rút hàng tháng withdrawAmount
         * Output:
         *      + Số năm mà tài khoản cạn tiền, không thể rút withdrawAmount được nữa
         *      + Nếu dòng tiền vô hạn thì ra một thông báo "The infinite amount of money."
         * Bước 1: Nhập các tham số balance, interestRate, withdrawAmount
         * Bước 2: Xét balance * interestRate / 12 >= withdrawAmount:
         *      + Nếu biểu thức đúng thì in ra thông báo "The infinite amount of money." và thoát chương trình.
         *      + Nếu biểu thức sai thì tiếp tục đến bước 3
         * Bước 3: Đặt monthCount là số tháng rút được số tiền withdrawAmount, gán monthCount := 0
         * Bước 4: Xét balance:
         *      + Nếu balance > 0 thì tiếp tục đến bước 5
         *      + Nếu balance <= 0 thì nhảy đến bước 8
         * Bước 5: Tính tiền lãi interestAmount := balance * interestRate / 12
         * Bước 6: Tính lại số dư sau khi đã rút withdrawAmount: balance := balance + interestAmount - withdrawAmount
         * Bước 7: Tăng biến monthCount lên 1 đơn vị, và quay lại bước 4
         * Bước 8: Tính số năm tài khoản không thể rút tiền được nữa với biểu thức: monthCount / 12 (kết quả làm tròn lên)
         * */
        exercise8R114Method(10000.0, 0.06, 500.0);
        exercise8R114Method(10000.0, 0.06, 60.0);
        exercise8R114Method(10000.0, 0.06, 50.0);

        /* Bài 8 - E1.4 */
        exercise8E14Method(1000.0, 0.05, 1);
        exercise8E14Method(1000.0, 0.05, 2);
        exercise8E14Method(1000.0, 0.05, 3);
    }
}
