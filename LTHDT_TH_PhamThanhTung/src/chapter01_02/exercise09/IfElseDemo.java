/*
 *  @ (#) IfElseDemo.java      1.0 19/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter01_02.exercise09;

/**
 * Chương trình xếp loại (grade) dựa trên điểm số (testScore)
 * @author: tungpt
 * @version: 1.0
 * @since: August 19, 2023
 */
public class IfElseDemo {
    public static void main(String[] args) {
        int testScore = 78;
        char grade;
        if (testScore >= 90) {
            grade = 'A';
        } else if (testScore >= 80) {
            grade = 'B';
        } else if (testScore >= 70) {
            grade = 'C';
        } else if (testScore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
    }
}

