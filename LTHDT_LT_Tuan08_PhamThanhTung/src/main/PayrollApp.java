/*
 *  @ (#) PayrollApp.java      1.0 19/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 19, 2023
 */
public class PayrollApp {
    public static void main(String[] args) {
        Employee employee1 = new HourlyEmployee("H002","Morgan, Harry", LocalDate.of(1995,2,12), 50,10.0);
        Employee employee2 = new HourlyEmployee("H001","Walker, Peter", LocalDate.of(1996,7,10), 40,10.0);
        Employee employee3 = new HourlyEmployee("H003","Smith, John", LocalDate.of(1999,5,3), 39,10.0);
        Employee employee4 = new SalariedEmployee("S005","Sirius, Joseph", LocalDate.of(1992,12,12), 50200.0);
        Employee employee5 = new SalariedEmployee("S004","Brown, Sofia", LocalDate.of(1996,8,22), 60000.0);
        Employee employee6 = new SalariedEmployee("S009","Cassandra, Rudy", LocalDate.of(1997,1,29), 40000.0);
        Employee employee7 = new Manager("S006","Oak, Morphia", LocalDate.of(1994,12,11), 50000.0, 50.0);
        Employee employee8 = new Manager("S008","Lemantine, Katherin", LocalDate.of(1995,9,10), 50000.0, 35.0);
        Employee employee9 = new Manager("S007","Parker, Martin", LocalDate.of(1998,7,6), 50000.0, 45.0);
        Employee[] employees = {employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9};
        EmployeeList employeeList = new EmployeeList();
        employeeList.addAll(employees);

        /* Bắt đầu MENU */
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào

        Employee employee;
        int type;
        String id;
        String name;
        LocalDate dob;
        int hoursWorked;
        double hourlyWage;
        double annualSalary;
        double weeklyBonus;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");

        while (flag){
            // Phần mô tả của Menu
            System.out.println("\n\n---------- EMPLOYEE MANAGEMENT SYSTEM ----------");
            System.out.println("\t[ 1 ] Display all employees.");
            System.out.println("\t[ 2 ] Add a new employee.");
            System.out.println("\t[ 3 ] Search employee by id.");
            System.out.println("\t[ 4 ] Sort by weekly salary.");
            System.out.println("\t[ 5 ] Remove employee by id.");
            System.out.println("\t[ 6 ] Update employee by id.");
            System.out.println("\t[ 7 ] List hourly employees who work than 40 hours a week.");
            System.out.println("\t[ 8 ] Print the total weekly salary of all managers.");
            System.out.println("\t[ 9 ] Update hourly worked of hourly employee by id.");
            System.out.println("\t[ 10 ] List of employees who are young managers (less than 30 years old).");
            System.out.println("\t[ 0 ] Exit.");
            System.out.println("-------------------------------------------------");
            System.out.print("\nEnter your choice: ");

            // Phần xử lý tuỳ chọn cho Menu
            input = scanner.nextLine().trim();
            try {
                option = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                option = -1;    // tuỳ chọn mặc định để tiếp tục vòng lặp
            }

            // Phần thân của Menu, chạy các lệnh phù hợp với tuỳ chọn tương ứng
            switch (option) {
                case 1:
                    System.out.println("[ 1 ] Display all employees");
                    Arrays.stream(employeeList.getEmployees()).forEach(emp -> System.out.println("\n" + emp));
                    break;
                case 2:
                    System.out.println("[ 2 ] Add a new employee.");
                    System.out.print("Enter 1, 2 or 3 to choice employee type (1-Hourly employee (default); 2-Salaried employee; 3-Manager): ");
                    try {
                        type = Integer.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        type = -1;
                    }
                    System.out.print("Enter id: ");
                    id = scanner.nextLine().trim();
                    System.out.print("Enter name: ");
                    name = scanner.nextLine().trim();
                    System.out.print("Enter date of birth (Example: 25/12/1999): ");
                    try {
                        dob = LocalDate.parse(scanner.nextLine().trim(), dateTimeFormatter);
                    } catch (DateTimeParseException e) {
                        dob = LocalDate.now();
                    }
                    switch (type) {
                        case 2:
                            try {
                                System.out.print("Enter annual salary: ");
                                annualSalary = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                annualSalary = 0.0;
                            }
                            employee = new SalariedEmployee(id, name, dob, annualSalary);
                            break;
                        case 3:
                            try {
                                System.out.print("Enter annual salary: ");
                                annualSalary = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                annualSalary = 0.0;
                            }
                            try {
                                System.out.print("Enter weekly bonus: ");
                                weeklyBonus = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                weeklyBonus = 0.0;
                            }
                            employee = new Manager(id, name, dob, annualSalary, weeklyBonus);
                            break;
                        default:
                            try {
                                System.out.print("Enter hours worked: ");
                                hoursWorked = Integer.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                hoursWorked = 0;
                            }
                            try {
                                System.out.print("Enter hourly wage: ");
                                hourlyWage = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                hourlyWage = 0.0;
                            }
                            employee = new HourlyEmployee(id, name, dob, hoursWorked, hourlyWage);
                            break;
                    }
                    try {
                        employeeList.addEmployee(employee);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("[ 3 ] Search employee by id.");
                    System.out.print("Enter id: ");
                    id = scanner.nextLine().trim();
                    employee = employeeList.searchEmployeeById(id);
                    if (employee == null) {
                        System.out.println("Không tồn tại nhân viên có số ID là " + id);
                    } else {
                        System.out.println(employee);
                    }
                    break;
                case 4:
                    System.out.println("[ 4 ] Sort by weekly salary.");
                    employeeList.sortByWeeklySalary();
                    break;
                case 5:
                    System.out.println("[ 5 ] Remove employee by id.");
                    System.out.print("Enter id: ");
                    id = scanner.nextLine().trim();
                    employeeList.removeEmployee(id);
                    break;
                case 6:
                    System.out.println("[ 6 ] Update employee by id.");
                    System.out.print("Enter 1, 2 or 3 to choice employee type (1-Hourly employee (default); 2-Salaried employee; 3-Manager): ");
                    try {
                        type = Integer.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        type = -1;
                    }
                    System.out.print("Enter id: ");
                    id = scanner.nextLine().trim();
                    System.out.print("Enter name: ");
                    name = scanner.nextLine().trim();
                    System.out.print("Enter date of birth (Example: 25/12/1999): ");
                    try {
                        dob = LocalDate.parse(scanner.nextLine().trim(), dateTimeFormatter);
                    } catch (DateTimeParseException e) {
                        dob = LocalDate.now();
                    }
                    switch (type) {
                        case 2:
                            try {
                                System.out.print("Enter annual salary: ");
                                annualSalary = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                annualSalary = 0.0;
                            }
                            employee = new SalariedEmployee(id, name, dob, annualSalary);
                            break;
                        case 3:
                            try {
                                System.out.print("Enter annual salary: ");
                                annualSalary = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                annualSalary = 0.0;
                            }
                            try {
                                System.out.print("Enter weekly bonus: ");
                                weeklyBonus = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                weeklyBonus = 0.0;
                            }
                            employee = new Manager(id, name, dob, annualSalary, weeklyBonus);
                            break;
                        default:
                            try {
                                System.out.print("Enter hours worked: ");
                                hoursWorked = Integer.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                hoursWorked = 0;
                            }
                            try {
                                System.out.print("Enter hourly wage: ");
                                hourlyWage = Double.valueOf(scanner.nextLine().trim());
                            } catch (NumberFormatException e) {
                                hourlyWage = 0.0;
                            }
                            employee = new HourlyEmployee(id, name, dob, hoursWorked, hourlyWage);
                            break;
                    }
                    try {
                        employeeList.updateEmployee(employee);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("[ 7 ] List hourly employees who work than 40 hours a week.");
                    Arrays.stream(employeeList.getHourlyEmpsWorkMoreThan40()).forEach(emp -> System.out.println("\n" + emp));
                    break;
                case 8:
                    System.out.println("[ 8 ] Print the total weekly salary of all managers.");
                    System.out.println("Total: " + decimalFormat.format(employeeList.getYoungEmployeesAsManagers()));
                    break;
                case 9:
                    System.out.println("[ 9 ] Update hourly worked of hourly employee by id.");
                    System.out.print("Enter id: ");
                    id = scanner.nextLine().trim();
                    int newHour;
                    try {
                        System.out.print("Enter new hours: ");
                        newHour = Integer.valueOf(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        newHour = 0;
                    }
                    try {
                        employeeList.updateHourlyWorked(id, newHour);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("[ 10 ] List of employees who are young managers (less than 30 years old).");
                    Arrays.stream(employeeList.getYoungEmployeesAsManagers()).forEach(emp -> System.out.println("\n" + emp));
                    break;
                case 0:
                    System.out.println("[ 0 ] Exit.");
                    flag = false;
                    break;
                default: break;
            }
        }
        // Kết thúc MENU
    }
}
