/*
 *  @ (#) PrintShapesVersion1.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise28;

import java.util.Scanner;

/**
 * chương trình in ra hình
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class PrintShapesVersion1 {
    public static void main(String[] args) {
        String EXISTENCE = "* ";      // asterisk
        String NONEXISTENCE = "  ";   // blank
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài cạnh: ");
        int side = Integer.valueOf(scanner.nextLine().trim());
        int center = (side - 1) / 2;
        int parity = 1;  // lẻ
        if (side % 2 == 0) {
            parity = 2; // chẵn
        }

        System.out.println("Hình 1. Hình tam giác vuông cân có chiều dài cạnh góc vuông là " + side + "; hình rỗng.");
        /* ---
        *
        * *
        *   *
        *     *
        *       *
        *         *
        *           *
        *             *
        * * * * * * * * *
        --- */

        for (int i = 0; i < side; i++) {
            // Xử lý hàng đầu và hàng cuối
            if ((i == 0) || (i == side - 1)) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(EXISTENCE);
                }
            } else {    // Xử lý các hàng ở giữa (còn lại)
                System.out.print(EXISTENCE);
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(NONEXISTENCE);
                }
                System.out.print(EXISTENCE);
            }
            System.out.println();
        }

        System.out.println("\nHình 2. Hình vuông có chiều dài cạnh là " + side + " và có hai đường chéo; hình rỗng.");
        /* ---
        * * * * * * * * *
        * *           * *
        *   *       *   *
        *     *   *     *
        *       *       *
        *     *   *     *
        *   *       *   *
        * *           * *
        * * * * * * * * *
        --- */

        for (int i = 0; i < side; i++) {
            // Xử lý hàng đầu và hàng cuối
            if ((i == 0) || (i == side - 1)) {
                for (int j = 0; j < side; j++) {
                    System.out.print(EXISTENCE);
                }
            } else {    // Xử lý các hàng ở giữa (còn lại)
                if (i == center) {  // Xử lý (các) hàng trung tâm
                    System.out.print(EXISTENCE);
                    for (int k = 0; k < center - 1; k++) {
                        System.out.print(NONEXISTENCE);
                    }
                    if (parity == 2) {
                        System.out.print(EXISTENCE + EXISTENCE);
                    } else {
                        System.out.print(EXISTENCE);
                    }
                    for (int k = 0; k < center - 1; k++) {
                        System.out.print(NONEXISTENCE);
                    }
                    System.out.print(EXISTENCE);
                } else if (i < center) {    // Xử lý (các) hàng nằm trên hàng trung tâm
                    System.out.print(EXISTENCE);
                    for (int j = 0; j < i - 1; j++) {
                        System.out.print(NONEXISTENCE);
                    }
                    System.out.print(EXISTENCE);
                    for (int j = 0; j < side - 2*(i + 1); j++) {
                        System.out.print(NONEXISTENCE);
                    }
                    System.out.print(EXISTENCE);
                    for (int j = 0; j < i - 1; j++) {
                        System.out.print(NONEXISTENCE);
                    }
                    System.out.print(EXISTENCE);
                } else {    // Xử lý (các) hàng nằm dưới hàng trung tâm
                    System.out.print(EXISTENCE);
                    for (int j = 0; j < (side - i - 2); j++) {
                        System.out.print(NONEXISTENCE);
                    }
                    System.out.print(EXISTENCE);
                    for (int j = 0; j < 2*(i - center) - parity; j++) {
                        System.out.print(NONEXISTENCE);
                    }
                    System.out.print(EXISTENCE);
                    for (int j = 0; j < (side - i - 2); j++) {
                        System.out.print(NONEXISTENCE);
                    }
                    System.out.print(EXISTENCE);
                }
            }
            System.out.println();
        }

        System.out.println("\nHình 3. Dạng hình sao: Chữ X và một dấu gạch ngang ở giữa chữ X, các đường tạo thành hình đều có độ dài là " + side + ".");
        /* ---
        *               *
          *           *
            *       *
              *   *
        * * * * * * * * *
              *   *
            *       *
          *           *
        *               *
        --- */

        if (parity == 2) {
            System.out.println("Không thể in ra hình có độ dài cạnh là " + side + " (vì là số chẵn).");
            System.exit(0);
        }
        for (int i = 0; i < side; i++) {
            // Xử lý hàng trung tâm
            if (i == center) {
                for (int j = 0; j < side; j++) {
                    System.out.print(EXISTENCE);
                }
            } else if (i < center) {    // Xử lý (các) hàng nằm trên hàng trung tâm
                for (int j = 0; j < i; j++) {
                    System.out.print(NONEXISTENCE);
                }
                System.out.print(EXISTENCE);
                for (int j = 0; j < 2*(center - i) - 1; j++) {
                    System.out.print(NONEXISTENCE);
                }
                System.out.print(EXISTENCE);
                for (int j = 0; j < i; j++) {
                    System.out.print(NONEXISTENCE);
                }
            } else {    // Xử lý (các) hàng nằm dưới hàng trung tâm
                for (int j = 0; j < (side - i - 1); j++) {
                    System.out.print(NONEXISTENCE);
                }
                System.out.print(EXISTENCE);
                for (int j = 0; j < 2*(i - center) - 1; j++) {
                    System.out.print(NONEXISTENCE);
                }
                System.out.print(EXISTENCE);
                for (int j = 0; j < (side - i - 1); j++) {
                    System.out.print(NONEXISTENCE);
                }
            }
            System.out.println();
        }
    }
}
