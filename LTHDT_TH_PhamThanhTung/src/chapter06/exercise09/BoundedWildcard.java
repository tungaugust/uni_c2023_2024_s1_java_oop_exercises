/*
 *  @ (#) BoundedWildcard.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise09;

import java.util.ArrayList;
import java.util.List;

/**
 * bounded wildcard: GenericType<? extends upperBoundType>
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class BoundedWildcard {
    public static double getAverage(List<? extends Number> numberList){
        double total = 0.0;
        for (Number number: numberList){
            total += number.doubleValue();
        }
        return total / numberList.size();
    }
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(3);
        integerList.add(30);
        integerList.add(300);
        System.out.println(getAverage(integerList)); // KQ=111.0
        List<Double> doubleList = new ArrayList<Double>();
        doubleList.add(3.0);
        doubleList.add(33.0);
        System.out.println(getAverage(doubleList)); // KQ=18.0
    }
}
