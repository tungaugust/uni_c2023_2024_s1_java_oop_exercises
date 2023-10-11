/*
 *  @ (#) TwoGenericsTest.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise02;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class TwoGenericsTest {
    public static void main(String[] args) {
        TwoGenerics<Integer, String> obj = new TwoGenerics<>(88, "Generics");
        obj.showType();

        int i = obj.getObj1();
        String s = obj.getObj2();
        System.out.println("Value: " + i);
        System.out.println("Value: " + s);
    }
}
