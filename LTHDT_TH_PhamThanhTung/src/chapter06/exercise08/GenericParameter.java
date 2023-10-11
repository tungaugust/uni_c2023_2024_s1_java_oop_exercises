/*
 *  @ (#) GenericParameter.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise08;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class GenericParameter {
    public static void printList (List<?> list){
        for (Object e: list){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add ("Hello");
        list1.add ("World");
        printList (list1);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(100);
        list2.add(200);
        printList(list2);
    }
}
