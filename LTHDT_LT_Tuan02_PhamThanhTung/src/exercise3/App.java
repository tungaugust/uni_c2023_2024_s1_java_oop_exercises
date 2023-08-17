/*
 *  @ (#) App.java      1.0 17/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package exercise3;

import java.util.Scanner;

/**
 * Giải phương trình bậc hai một ẩn aX^2 + bX + c = 0.
 * @author: tungpt
 * @version: 1.0
 * @since: August 17, 2023
 */
public class App {
    public static void main(String[] args) {
        /*
        * Bài 3.1. Thuật toán giải phương trình bậc hai một ẩn aX^2 + bX + c = 0
        * Input: Hệ số a, b và c của phương trình bậc hai (tổng quát)
        * Output: Nghiệm X (nghiệm kép), X1 và X2 (hai nghiệm phân biệt) của phương trình bậc hai
        * Bước 1: Tính Delta = b^2 - 4ac
        * Bước 2: Xét Delta
        *   + Delta < 0: Phương trình vô nghiệm
        *   + Delta = 0: Phương trình có nghiệp kép X1 = X2 = -b/(2a)
        *   + Delta > 0: Phương trình có hai nghiệm phân biệt, với:
        *   X1 = (-b + sqrt(Delta))/(2a) và X2 = (-b - sqrt(Delta))/(2a)
        * */

        /*
        * Bài 3.2. Chương trình nhập các hệ số a, b và c để giải phương trình bậc hai một ẩn  aX^2 + bX + c = 0
        * Giải và in ra nghiệm của chương trình.
        * */
        // tạo đối tượng Scanner cho việc nhập dữ liệu từ console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập hệ số của phương trình aX^2 + bX + c = 0.");
        System.out.print("Hệ số a = ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        double a = Double.valueOf(scanner.nextLine().trim());
        System.out.print("Hệ số b = ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        double b = Double.valueOf(scanner.nextLine().trim());
        System.out.print("Hệ số c = ");
        // nhập chuỗi, chuỗi cắt tỉa chuỗi ở đầu và cuối, chuyển chuỗi thành số thực kiểu double.
        double c = Double.valueOf(scanner.nextLine().trim());
        // bước 1: tính Delta
        double delta = Math.pow(b, 2) - 4*a*c;
        // bước 2: biện luận số nghiệm của phương trình bậc hai một ẩn theo Delta bằng câu lệnh if
        if (delta < 0) {
            System.out.println("\nPhương trình vô nghiệm.");
        } else if (delta == 0) {
            double x = -b/(2*a);
            System.out.printf("\nPhương trình có nghiệm kép X1 = X2 = %.2f\n", x);
        } else { // delta > 0
            double x1 = (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2*a);
            System.out.printf("\nPhương trình hai nghiệm phân biệt X1 = %.2f và X2 = %.2f\n", x1, x2);
        }
    }
}
