/*
 *  @ (#) PersonTest.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise04;

import java.util.Arrays;

/**
 * Generic Comparable Interface
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class PersonTest {
    public static void main(String[] args) {
        Person[] authors = {
                new Person("D", "S"),
                new Person("J", "G"),
                new Person("T", "C"),
                new Person("C", "S"),
                new Person("P", "C"),
                new Person("B", "B")
        };
        Arrays.sort(authors);
        System.out.println("Sau khi sắp xếp:");
        for (Person author: authors) {
            System.out.println(author);
        }

        Person[] people = {
                new Person("C", "S"),
                new Person("N", "K"),
                new Person("T", "C"),
                new Person("C", "D")
        };
        int index = 0;
        System.out.println("\nTìm kiếm:");
        for (Person person : people) {
            index = Arrays.binarySearch(authors, person);
            if (index >= 0){
                System.out.println(person + " tại vị trí index = " + index);
            } else {
                System.out.println(person + " không tìm thấy. Giá trị trả về: " + index);
            }
        }
    }
}
