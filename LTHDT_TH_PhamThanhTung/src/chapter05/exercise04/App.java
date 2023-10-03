/*
 *  @ (#) App.java      1.0 03/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise04;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 03, 2023
 */
public class App {
    static <T> void printSet(Set<T> set){
        set.stream().forEach(e -> System.out.print(e + " "));
    }
    public static void main(String[] args) {
        Integer[] s1 = {1, 2, 3, 7, 8, 9};
        Integer[] s2 = {2, 5, 6, 9, 10};
        Set<Integer> set1 = new TreeSet<>(Arrays.asList(s1));
        Set<Integer> set2 = new TreeSet<>(Arrays.asList(s2));
        Set<Integer> set3 = new HashSet<>(set1);
        Set<Integer> set4 = new HashSet<>(set1);
        System.out.print("set1: ");
        printSet(set1);
        System.out.print("\nset2: ");
        printSet(set2);

        System.out.println("\n+ Union of set1 and set2");
        set1.addAll(set2);
        System.out.print("set1: ");
        printSet(set1);

        System.out.println("\n+ Intersection of set1 and set2");
        set3.retainAll(set2);
        System.out.print("set1: ");
        printSet(set3);

        System.out.println("\n+ Set difference of set1 and set2");
        set4.removeAll(set2);
        System.out.print("set1: ");
        printSet(set4);
    }
}
