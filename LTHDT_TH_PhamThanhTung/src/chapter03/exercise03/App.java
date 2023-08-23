/*
 *  @ (#) App.java      1.0 24/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise03;

/**
 * Chương trình quản lý thông tin đăng kí xe
 * @author: tungpt
 * @version: 1.0
 * @since: August 24, 2023
 */
public class App {
    static double tax(Vehicle vehicle){
        double taxRate = 1; // thuế suất (%)
        if ((vehicle.getCapacity() >= 100) && (vehicle.getCapacity() <= 200)) {
            taxRate = 3;
        } else if (vehicle.getCapacity() > 200) {
            taxRate = 5;
        }
        return (vehicle.getUnitPrice() * taxRate) / 100;
    }
    public static void main(String[] args) {
        Vehicle xe1 = new Vehicle("Future Neo", 100, 35000000.0);
        Vehicle xe2 = new Vehicle("Ford Ranger", 3000, 250000000.0);
        Vehicle xe3 = new Vehicle( "Landcape", 1500, 1000000000.0);

        String headerLine = String.format("%-30s %-20s %15s %20s %20s",
                "Tên chủ xe", "Loại xe", "Dung tích", "Trị giá", "Thuế phải nộp"
        );
        System.out.println(headerLine);
        String lineSymbol = "=";
        for (int i = 0; i < headerLine.length(); i++) {
            System.out.print(lineSymbol);
        }
        System.out.println();

        System.out.printf("%-30s %s %20.2f\n", "Nguyễn Thu Loan", xe1, tax(xe1));
        System.out.printf("%-30s %s %20.2f\n", "Lê Minh Tính", xe2, tax(xe2));
        System.out.printf("%-30s %s %20.2f\n", "Nguyễn Minh Triết", xe3, tax(xe3));
    }
}
