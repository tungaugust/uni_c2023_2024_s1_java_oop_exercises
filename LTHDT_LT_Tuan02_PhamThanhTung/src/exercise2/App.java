/*
 *  @ (#) App.java      1.0 17/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise2;

import java.util.Scanner;

/**
 * Giải phương trình bậc nhất một ẩn aX + b = 0.
 * @author: tungpt
 * @version: 1.0
 * @since: August 17, 2023
 */
public class App {
    public static void main(String[] args) {
        // tạo đối tượng Scanner cho việc nhập dữ liệu từ console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập hệ số của phương trình aX + b = 0.");
        System.out.print("Hệ số a = ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        double a = Double.valueOf(scanner.nextLine().trim());
        System.out.print("Hệ số b = ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        double b = Double.valueOf(scanner.nextLine().trim());
        // biện luận số nghiệm của phương trình bậc nhất một ẩn bằng câu lệnh if
        if (a != 0) {
            System.out.printf("\nPhương trình có duy nhất nghiệm: %.2f\n", -b/a);
        } else if ((a == 0) && (b == 0)) {
            System.out.println("\nPhương trình có vô số nghiệm.");
        } else {
            System.out.println("\nPhương trình vô nghiệm.");
        }
    }
}
