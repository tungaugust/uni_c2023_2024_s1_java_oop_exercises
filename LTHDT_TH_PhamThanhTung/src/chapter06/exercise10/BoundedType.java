/*
 *  @ (#) BoundedType.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise10;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */

class Stats<T extends Number>{
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }
    double average(){
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }
}
public class BoundedType {
    public static void main(String[] args) {
        Integer inums[] = { 1, 2, 3, 4, 5 };
        Stats<Integer> iob = new Stats<Integer>(inums);
        double v = iob.average();
        System.out.println("Trung bình mảng số nguyên: " + v);
        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats<Double> dob = new Stats<Double>(dnums);
        double w = dob.average();
        System.out.println("Trung bình mảng số thực: " + w);
    }
}
