/*
 *  @ (#) PrintShapesVersion2.java      1.0 21/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise29;

import java.util.Scanner;

/**
 * chương trình in ra hình
 * @author: tungpt
 * @version: 1.0
 * @since: August 21, 2023
 */
public class PrintShapesVersion2 {
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

        System.out.println("Hình a. Hình tam giác vuông cân có độ dài cạnh góc vuông là " + side + ".");
        /* ---
        *
        * *
        * * *
        * * * *
        * * * * *
        * * * * * *
        * * * * * * *
        --- */

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(EXISTENCE);
            }
            System.out.println();
        }

        System.out.println("\nHình b. Hình tam giác vuông cân (ngược) có độ dài cạnh góc vuông là " + side + ".");
        /* ---
        * * * * * * *
        * * * * * *
        * * * * *
        * * * *
        * * *
        * *
        *
        --- */

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side - i; j++) {
                System.out.print(EXISTENCE);
            }
            System.out.println();
        }

        System.out.println("\nHình c. Hình tam giác cân có độ dài đường cao là " + side + ".");
        /* ---
                          *
                        * * *
                      * * * * *
                    * * * * * * *
                  * * * * * * * * *
                * * * * * * * * * * *
              * * * * * * * * * * * * *
            * * * * * * * * * * * * * * *
          * * * * * * * * * * * * * * * * *
        * * * * * * * * * * * * * * * * * * *
        --- */

        // Độ dài cạnh đáy bằng = Đường cao * 2 - 1
        int base = side * 2 - 1;
        int edgeWidth = 1;  // độ rộng của tầng chóp của tam giác
        int voidWidth = (base - edgeWidth) / 2; // độ rộng phần trống mỗi bên
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < voidWidth; j++) {
                System.out.print(NONEXISTENCE);
            }
            for (int j = 0; j < edgeWidth; j++) {
                System.out.print(EXISTENCE);
            }
            for (int j = 0; j < voidWidth; j++) {
                System.out.print(NONEXISTENCE);
            }
            System.out.println();
            voidWidth--;
            edgeWidth += 2;
        }

        System.out.println("\nHình d. Hình tam giác cân có độ dài đường cao là " + side + "; hình rỗng.");
        /* ---
                          *
                        *   *
                      *       *
                    *           *
                  *               *
                *                   *
              *                       *
            *                           *
          *                               *
        * * * * * * * * * * * * * * * * * * *
        --- */

        edgeWidth = 1;
        voidWidth = (base - edgeWidth) / 2;
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < voidWidth; j++) {
                System.out.print(NONEXISTENCE);
            }
            if ((i == 0) || (i == side - 1)) {
                for (int j = 0; j < edgeWidth; j++) {
                    System.out.print(EXISTENCE);
                }
            } else {
                System.out.print(EXISTENCE);
                for (int j = 0; j < edgeWidth - 2; j++) {
                    System.out.print(NONEXISTENCE);
                }
                System.out.print(EXISTENCE);
            }

            for (int j = 0; j < voidWidth; j++) {
                System.out.print(NONEXISTENCE);
            }
            System.out.println();
            voidWidth--;
            edgeWidth += 2;
        }
    }
}
