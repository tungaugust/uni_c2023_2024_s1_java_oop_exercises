/*
 *  @ (#) GenericStatsTest.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise11;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class GenericStatsTest {
    public static void main(String[] args) {
        Integer inums[] = { 1, 2, 3, 4, 5 };
        GenericStats<Integer> iob = new GenericStats<Integer>(inums);
        double v = iob.average();
        System.out.println("Trung bình của mảng integer " + v);
        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        GenericStats<Double> dob = new GenericStats<Double>(dnums);
        double w = dob.average();
        System.out.println("Trung bình của mảng double " + w);
        Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
        GenericStats<Float> fob = new GenericStats<Float>(fnums);
        double x = fob.average();
        System.out.println("Trung bình của mảng float: " + x);
        System.out.print("Trung bình của mảng integer và double ");
        if(iob.sameAvg(dob)){
            System.out.println("giống nhau.");
        } else {
            System.out.println("khác nhau.");
        }
        System.out.print("Trung bình của mảng integer và float ");
        if(iob.sameAvg(fob)) {
            System.out.println("giống nhau.");
        } else {
            System.out.println("khác nhau.");
        }
    }
}
