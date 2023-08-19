/*
 *  @ (#) RandomExercise.java      1.0 20/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise09;

import java.util.Random;

/**
 * Chương trình tạo số ngẫu nhiên
 * @author: tungpt
 * @version: 1.0
 * @since: August 20, 2023
 */
public class RandomExercise {
    public static void main(String[] args) {
        Random random = new Random();
        int n = random.nextInt();
        System.out.println("Number: " + n);

        int min = 1;
        int max = 9;
        int m = random.nextInt(max - min + 1) + min;
        System.out.printf("Số ngẫu nhiên trong khoảng [%d,%d]: %d", min, max, m);
    }
}
