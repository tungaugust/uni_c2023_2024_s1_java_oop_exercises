/*
 *  @ (#) App.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise03;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Chương trình quản lý nhân viên trong một công ty phần mềm (SoftwareHouse)
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class App {
    public static void main(String[] args) {
        SoftwareHouse company = new SoftwareHouse("Software House");
        Employee employee1 = new Programmer(1010, "Lê Quang Nhân", 5000.0, "Java");
        Employee employee2 = new Programmer(1005, "Trần Trọng Nghĩa", 5000.0, "C++");
        Employee employee3 = new Programmer(1100, "Lý Hoàng Lễ", 5000.0, "Scala");
        Employee employee4 = new Programmer(1001, "Đinh Minh Trí", 5000.0, "Java");
        Employee employee5 = new Programmer(1109, "Triệu Trung Dũng", 5000.0, "Python");
        Employee employee6 = new Programmer(1120, "Nguyễn Trọng Tín", 5000.0, "C#");
        Employee employee7 = new Programmer(1002, "Hồ Khải Chân", 5000.0, "Python");
        Employee employee8 = new Programmer(1050, "Chu Vĩnh Thiện", 5000.0, "C++");
        Employee employee9 = new Programmer(1091, "Mạc Diệu Mỹ", 5000.0, "Scala");
        Employee employee10 = new ProjectLeader(1200, "Phạm Thanh Phong ", 7000.0, "Java");
        Employee employee11 = new ProjectLeader(1211, "Võ Huyền Hoa ", 6500.0, "Scala");
        Employee employee12 = new Administrator(1015, "Dương Ánh Tuyết ", 10000.0, "Dev-Dept");
        Employee employee13 = new Administrator(1040, "La Dạ Nguyệt ", 9000.0, "Test-Dept");

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);
        company.addEmployee(employee4);
        company.addEmployee(employee5);
        company.addEmployee(employee6);
        company.addEmployee(employee7);
        company.addEmployee(employee8);
        company.addEmployee(employee9);
        company.addEmployee(employee10);
        company.addEmployee(employee11);
        company.addEmployee(employee12);
        company.addEmployee(employee13);

        /* Bắt đầu MENU */
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;    // cờ điều khiển vòng lặp cho menu
        int option; // tuỳ chọn
        String input; // chuỗi tuỳ chọn đầu vào
        String headerLine = String.format("%-5s | %-10s | %-25s | %-15s | %15s",
                "STT", "Mã NV", "Tên NV", "Lương cơ bản", "Thông tin"
        );
        String lineSymbol = "=";

        int employeeType = 3;   // phân loại nhân viên
        Employee employee;
        int thePayrollNumber;
        String theName;
        double theBasicMonthlySalary;
        String bonusInfo;

        while (flag) {
            // Phần mô tả của Menu
            System.out.println("\n\n---------- MENU ----------");
            System.out.println("\t[ 1 ] Thêm 01 nhân viên vào công ty.");
            System.out.println("\t[ 2 ] Hiển thị danh sách toàn bộ nhân viên trong công ty.");
            System.out.println("\t[ 3 ] Tổng tiền công ty trả cho nhân viên trong 01 tháng.");
            System.out.println("\t[ 4 ] Sắp xếp danh sách nhân viên theo tên.");
            System.out.println("\t[ 5 ] Hiển thị danh sách các lập trình viên trong công ty.");
            System.out.println("\t[ 6 ] Cập nhật (thay đổi) phòng ban cho người quản lý.");
            System.out.println("\t[ 0 ] Thoát Menu.");
            System.out.println("--------------------------");
            System.out.print("\nNhập tuỳ chọn [ 0 - 6 ]: ");

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
                    System.out.println("[ 1 ] Thêm 01 nhân viên vào công ty.");
                    System.out.print(">>> Phân loại nhân viên muốn nhập thông tin, nhập (1 - Quản lý; 2 - Trưởng dự án; 3 - Lập trình viên, mặc định): ");
                    input = scanner.nextLine().trim();
                    if (input.equals("1")) {
                        employeeType = 1;
                    } else if (input.equals("2")) {
                        employeeType = 2;
                    }
                    System.out.print(">>> Nhập mã nhân viên: ");
                    input = scanner.nextLine().trim();
                    try {
                        thePayrollNumber = Integer.valueOf(input);
                    } catch (NumberFormatException e) {
                        thePayrollNumber = 0;
                    }
                    System.out.print(">>> Nhập tên nhân viên: ");
                    theName = scanner.nextLine().trim();
                    System.out.print(">>> Nhập tiền lương cơ bản (đơn vị: $): ");
                    input = scanner.nextLine().trim();
                    try {
                        theBasicMonthlySalary = Double.valueOf(input);
                    } catch (NumberFormatException e) {
                        theBasicMonthlySalary = 0.0;
                    }
                    // Tạo đối tượng
                    if (employeeType == 1) {
                        System.out.print(">>> Nhập tên phòng ban: ");
                        bonusInfo = scanner.nextLine().trim();
                        employee = new Administrator(thePayrollNumber, theName, theBasicMonthlySalary, bonusInfo);
                    } else {
                        System.out.print(">>> Nhập tên ngôn ngữ lập trình: ");
                        bonusInfo = scanner.nextLine().trim();
                        if (employeeType == 2) {
                            employee = new ProjectLeader(thePayrollNumber, theName, theBasicMonthlySalary, bonusInfo);
                        } else {
                            employee = new Programmer(thePayrollNumber, theName, theBasicMonthlySalary, bonusInfo);
                        }
                    }
                    // Thêm đối tượng vào danh sách
                    if (company.addEmployee(employee)){
                        System.out.println(">>> Thành công thêm nhân viên vào danh sách nhân viên của công ty.");
                    } else {
                        System.out.println(">>> Thêm nhân viên vào danh sách nhân viên của công ty không thành công.");
                    }
                    break;
                case 2:
                    System.out.println("[ 2 ] Hiển thị danh sách toàn bộ nhân viên trong công ty.");
                    System.out.println(headerLine);
                    for (int i = 0; i < headerLine.length(); i++) {
                        System.out.print(lineSymbol);
                    }
                    System.out.println();
                    company.displayAllStaff();
                    break;
                case 3:
                    System.out.println("[ 3 ] Tổng tiền công ty trả cho nhân viên trong 01 tháng.");
                    DecimalFormat decimalFormat = new DecimalFormat("$#,##0");
                    double amount = company.getMonthlySalaryBill();
                    System.out.println(">>> " + decimalFormat.format(amount));
                    break;
                case 4:
                    System.out.println("[ 4 ] Sắp xếp danh sách nhân viên theo tên.");
                    company.sortAllStaffByName();
                    break;
                case 5:
                    System.out.println("[ 5 ] Hiển thị danh sách các lập trình viên trong công ty.");
                    System.out.println(headerLine);
                    for (int i = 0; i < headerLine.length(); i++) {
                        System.out.print(lineSymbol);
                    }
                    System.out.println();
                    company.displayListProgrammers();
                    break;
                case 6:
                    System.out.println("[ 6 ] Cập nhật (thay đổi) phòng ban cho người quản lý.");
                    System.out.print(">>> Nhập mã nhân viên (của quản lý): ");
                    input = scanner.nextLine().trim();
                    try {
                        thePayrollNumber = Integer.valueOf(input);
                        System.out.print(">>> Nhập tên phòng ban: ");
                        input = scanner.nextLine().trim();
                        if (company.updateDepartmentForAdmin(thePayrollNumber, input)){
                            System.out.println(">>> Thành công cập nhật phòng ban mới của quản lý.");
                        } else {
                            System.out.println(">>> Không tìm thấy quản lý có mã nhân viên đã nhập.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(">>> Mã nhân viên không hợp lệ.");
                    }
                    break;
                case 0:
                    System.out.println("[ 0 ] Thoát MENU.");
                    flag = false;
                    break;
                default: break;
            }
        }
        /* Kết thúc MENU */
    }
}
