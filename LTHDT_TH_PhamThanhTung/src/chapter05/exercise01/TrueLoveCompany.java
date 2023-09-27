/*
 *  @ (#) TrueLoveCompany.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise01;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public class TrueLoveCompany {
    public static void main(String[] args) {
        Person person1 = new Employee("E001", "Doanh");
        Person person2 = new Employee("E002", "Hoa");
        Person person3 = new Employee("E003", "Duy");
        Person person4 = new Employee("E004", "Doanh");
        Person person5 = new Employee("E005", "Hữu");
        Person person6 = new Employee("E006", "Huân");
        Person person7 = new Employee("E007", "Doanh");
        Person person8 = new Employee("E008", "Phương");
        Person person9 = new Employee("E009", "Duy");
        Person person10 = new Employee("E010", "Duy");
        Person person11 = new Customer("C020", "Lệ", 100000.0);
        Person person12 = new Customer("C021", "Đài", 90000.0);
        Person person13 = new Customer("C022", "Trang", 120000.0);
        Person person14 = new Customer("C023", "Tương", 110000.0);
        Person person15 = new Customer("C024", "Tư", 80000.0);
        Person person16 = new Customer("C025", "Vọng", 150000.0);
        Person person17 = new Customer("C026", "Nguyệt", 130000.0);

        EmployeeList employeeList = new EmployeeList();
        CustomerList customerList = new CustomerList();
        employeeList.addEmployee(person1);
        employeeList.addEmployee(person2);
        employeeList.addEmployee(person3);
        employeeList.addEmployee(person4);
        employeeList.addEmployee(person5);
        employeeList.addEmployee(person6);
        employeeList.addEmployee(person7);
        employeeList.addEmployee(person8);
        employeeList.addEmployee(person9);
        employeeList.addEmployee(person10);
        customerList.addCustomer(person11);
        customerList.addCustomer(person12);
        customerList.addCustomer(person13);
        customerList.addCustomer(person14);
        customerList.addCustomer(person15);
        customerList.addCustomer(person16);
        customerList.addCustomer(person17);

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        while (flag) {
            // Phần mô tả của Menu
            System.out.println("\n\n---------- TRUE LOVE COMPANY ----------");
            System.out.println("\t[ 1 ] Chọn ngẫu nhiên một nhân viên để tặng quà.");
            System.out.println("\t[ 2 ] Đặt tên sản phẩm mới theo tên nhân viên ngẫu nhiên.");
            System.out.println("\t[ 3 ] Đặt tên sản phẩm mới theo tên phổ biến của tất cả nhân viên.");
            System.out.println("\t[ 4 ] Đăng kí đi du lịch cho nhân viên.");
            System.out.println("\t[ 5 ] Sắp xếp danh sách khách hàng với thứ tự tăng dần theo doanh số.");
            System.out.println("\t[ 6 ] In ra danh sách nhân viên.");
            System.out.println("\t[ 7 ] In ra danh sách khách hàng.");
            System.out.println("\t[ 8 ] In ra danh sách nhân viên đã đăng kí đi du lịch.");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 8 ]: ");

            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }

            switch (option){
                case 1:
                    System.out.println("[ 1 ] Chọn ngẫu nhiên một nhân viên để tặng quà.");
                    System.out.println("Nhân viên được chọn: " + employeeList.choiceRandomEmployee());
                    break;
                case 2:
                    System.out.println("[ 2 ] Đặt tên sản phẩm mới theo tên nhân viên ngẫu nhiên.");
                    System.out.println("Tên ngẫu nhiên được chọn cho sản phẩm mới: " + employeeList.choiceNameForNewProduct());
                    break;
                case 3:
                    System.out.println("[ 3 ] Đặt tên sản phẩm mới theo tên phổ biến của tất cả nhân viên.");
                    System.out.println("Tên phổ biến được chọn để đặt tên cho sản phẩm mới: " + employeeList.findPopularName());
                    break;
                case 4:
                    System.out.println("[ 4 ] Đăng kí đi du lịch cho nhân viên.");
                    System.out.print("Nhập mã nhân viên đăng kí đi du lịch: ");
                    input = scanner.nextLine().trim();
                    employeeList.register(input);
                    break;
                case 5:
                    System.out.println("[ 5 ] Sắp xếp danh sách khách hàng với thứ tự tăng dần theo doanh số.");
                    customerList.sortCustomerListBySaleValue();
                    break;
                case 6:
                    System.out.println("[ 6 ] In ra danh sách nhân viên.");
                    employeeList.printList();
                    break;
                case 7:
                    System.out.println("[ 7 ] In ra danh sách khách hàng.");
                    customerList.printList();
                    break;
                case 8:
                    System.out.println("[ 8 ] In ra danh sách nhân viên đã đăng kí đi du lịch.");
                    employeeList.printRegisteredEmployeeList();
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
