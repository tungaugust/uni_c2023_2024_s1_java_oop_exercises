/*
 *  @ (#) SolvingFirstDegreeEquation.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise16;

/**
 * Chương trình giải Phương trình bậc nhất một ẩn: aX + b = 0
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class SolvingFirstDegreeEquation {
    public static void main(String[] args) {
        // Tham số dòng lệnh nếu không được truyền thì xem như bằng 0.0
        double a = 0.0;
        double b = 0.0;
        if (args.length == 0) {
            System.out.println("Phương trình 0X + 0 = 0 có vô số nghiệm.");
            System.exit(0);
        }
        a = Double.valueOf(args[0].trim());
        if (args.length >= 2) {
            b = Double.valueOf(args[1].trim());
        }
        // Biện luận số nghiệm
        if ((a == 0) && (b == 0)) {
            System.out.printf("Phương trình %.2fX + %.2f = 0 vô nghiệm.\n", a, b);
        } else if ((a == 0) && (b != 0)) {
            System.out.printf("Phương trình %.2fX + %.2f = 0 vô nghiệm.\n", a, b);
        } else {
            System.out.printf("Phương trình %.2fX + %.2f = 0 có duy nhất nghiệm là %.2f\n", a, b, -b/a);
        }
    }
}
