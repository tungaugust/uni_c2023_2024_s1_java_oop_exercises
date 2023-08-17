/*
 *  @ (#) App.java      1.0 17/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise1;

import java.util.Scanner;

/**
 * Chương trình cho phép nhập họ tên, mã số sinh viên, câu khẩu hiệu và điểm trung bình mong muốn
 * khi học môn học này từ bàn phím, xuất kết quả.
 * @author: tungpt
 * @version: 1.0
 * @since: August 17, 2023
 */
public class App {
    public static void main(String[] args) {
        // tạo đối tượng Scanner cho việc nhập dữ liệu từ console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sinh viên.");
        System.out.print("- Họ và tên: ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, in hoa tất cả các kí tự trong chuỗi.
        String studentName = scanner.nextLine().trim().toUpperCase();
        System.out.print("- Mã số sinh viên: ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, in hoa tất cả các kí tự trong chuỗi.
        String studentCode = scanner.nextLine().trim().toUpperCase();
        System.out.print("- Khẩu hiệu: ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối.
        String slogan = scanner.nextLine().trim();
        System.out.print("- Điểm trung bình mong muốn: ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        double averageScore = Double.valueOf(scanner.nextLine().trim());
        System.out.println("\nXuất thông tin sinh viên.");
        // In các thông tin đã nhập bằng định dạng chuỗi với phương thức printf().
        System.out.printf(
                "Họ và tên: %s\n"
                + "Mã số sinh viên: %s\n"
                + "Khẩu hiệu: \"%s\"\n"
                + "Điểm trung bình mong muốn: %.2f"
                , studentName
                , studentCode
                , slogan
                , averageScore
        );
    }
}
