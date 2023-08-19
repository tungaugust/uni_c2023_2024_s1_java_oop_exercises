/*
 *  @ (#) VendingMachine.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise9;

import java.util.Scanner;

/**
 * CHƯƠNG TRÌNH GIẢI LẬP MÁY BÁN HÀNG TỰ ĐỘNG
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class VendingMachine {
    public static void main(String[] args) {
        final int PENNIES_PER_DOLLAR = 100; // Giá trị (cent) của một đồng xu dollar.
	    final int PENNIES_PER_QUARTER = 25; // Giá trị (cent) của một đồng xu quarter.

        int billValue; // Mệnh giá tiền theo mẫu hoá đơn được cho vào máy ($1, $2, $5, $10, $20, $50, và $100).
        int itemPrice; // Giá của hàng hoá muốn mua.
        int changeDue; // Tiền thừa với đơn vị xu (cent).
        int dollarCoins; // Số đồng xu dollar máy trả về.
        int quarters; // Số đồng xu quarter máy trả về.

        // Nhập mệnh giá theo mẫu hoá đơn và giá của hàng hoá muốn mua
        Scanner input = new Scanner(System.in);
        System.out.print("Enter bill value (1=$1, 2=$2, 5=$5, 10=$10, 20=$20, 50=$50, 100=$100): ");
        billValue = Integer.valueOf(input.nextLine().trim());
        System.out.print("Enter item price in pennies (cent unit): ");
        itemPrice = Integer.valueOf(input.nextLine().trim());

        // Tính tiền thừa
        changeDue = PENNIES_PER_DOLLAR * billValue - itemPrice;
        dollarCoins = changeDue / PENNIES_PER_DOLLAR;
        changeDue = changeDue % PENNIES_PER_DOLLAR;
        quarters = changeDue / PENNIES_PER_QUARTER;

        // In tiền thừa theo đồng xu dollar và quarter
        System.out.printf("Dollar coins:\t%03d\n", dollarCoins);
        System.out.printf("Quarters:\t\t%03d\n", quarters);
    }
}
