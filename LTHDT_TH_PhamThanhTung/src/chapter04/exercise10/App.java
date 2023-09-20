/*
 *  @ (#) App.java      1.0 13/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 13, 2023
 */
public class App {
    public static void main(String[] args) {
        Management management = new Management();
        Person person1 = new Student("Student 4", "Address 1", 8.1, 7.7);
        Person person2 = new Student("Student 9", "Address 2", 7.1, 9.9);
        Person person3 = new Student("Student 2", "Address 3", 6.1, 4.7);
        Person person4 = new Student("Student 6", "Address 4", 6.1, 5.9);
        Person person5 = new Student("Student 2", "Address 5", 4.1, 4.9);
        Person person6 = new Employee("Employee 3", "Address 6", 1.2);
        Person person7 = new Employee("Employee 5", "Address 7", 1.2);
        Person person8 = new Employee("Employee 2", "Address 8", 1.2);
        Person person9 = new Employee("Employee 7", "Address 9", 1.2);
        Person person10 = new Customer("Customer 9", "Address 10", "Company H", 35000000.0);
        Person person11 = new Customer("Customer 10", "Address 11", "Company A", 150000000.0);
        Person person12 = new Customer("Customer 7", "Address 12", "Company N", 87000000.0);
        Person person13 = new Customer("Customer 5", "Address 13", "Company Y", 40000000.0);
        Person person14 = new Customer("Customer 8", "Address 14", "Company S", 100000000.0);
        management.add(person1);
        management.add(person2);
        management.add(person3);
        management.add(person4);
        management.add(person5);
        management.add(person6);
        management.add(person7);
        management.add(person8);
        management.add(person9);
        management.add(person10);
        management.add(person11);
        management.add(person12);
        management.add(person13);
        management.add(person14);

        /* Bắt đầu MENU */
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        Person person;
        String name;
        String address;
        String company;
        double billPrice;
        double salaryRate;
        double score1, score2;
        int type;

        while (flag) {
            // Phần mô tả của Menu
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t[ 1 ] Thêm một người vào danh sách.");
            System.out.println("\t[ 2 ] Xoá một người khỏi danh sách theo tên.");
            System.out.println("\t[ 3 ] Sắp xếp danh sách theo thứ tự họ tên.");
            System.out.println("\t[ 4 ] Xuất danh sách.");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 4 ]: ");

            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }

            switch (option){
                case 1:
                    System.out.println("[ 1 ] Thêm một người vào danh sách.");
                    System.out.print("Nhập 1, 2 hoặc 3 để chọn phân loại cần thêm (1-Student (mặc định); 2-Employee; 3-Customer): ");
                    try {
                        type = Integer.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        type = -1;
                    }
                    System.out.print("Nhập họ tên: ");
                    name = scanner.nextLine().trim();
                    System.out.print("Nhập địa chỉ: ");
                    address = scanner.nextLine().trim();
                    switch (type) {
                        case 2:
                            try {
                                System.out.print("Nhập hệ số lương: ");
                                salaryRate = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                salaryRate = Employee.SALARY_BASE;
                            }
                            person = new Employee(name, address, salaryRate);
                            break;
                        case 3:
                            System.out.print("Nhập tên công ty: ");
                            company = scanner.nextLine().trim();
                            try {
                                System.out.print("Nhập giá trị của hoá đơn: ");
                                billPrice = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                billPrice = 0.0;
                            }
                            person = new Customer(name, address, company, billPrice);
                            break;
                        default:
                            try {
                                System.out.print("Nhập điểm số môn học 1: ");
                                score1 = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                score1 = 0.0;
                            }
                            try {
                                System.out.print("Nhập điểm số môn học 2: ");
                                score2 = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                score2 = 0.0;
                            }
                            person = new Student(name, address, score1, score2);
                            break;
                    }
                    management.add(person);
                    break;
                case 2:
                    System.out.println("[ 2 ] Xoá một người khỏi danh sách theo tên.");
                    System.out.print("Nhập họ tên: ");
                    name = scanner.nextLine().trim();
                    management.remove(name);
                    break;
                case 3:
                    System.out.println("[ 3 ] Sắp xếp danh sách theo thứ tự họ tên.");
                    management.sortByOrderdName();
                    break;
                case 4:
                    System.out.println("[ 4 ] Xuất danh sách.");
                    management.printPersonList();
                    break;
                case 0:
                    System.out.println("[ 0 ] Thoát MENU.");
                    flag = false;
                    break;
                default:
                    break;
            }
        }

        
    }
}
