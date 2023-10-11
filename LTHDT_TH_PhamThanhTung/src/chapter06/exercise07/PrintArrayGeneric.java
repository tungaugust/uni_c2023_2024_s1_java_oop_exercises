/*
 *  @ (#) PrintArrayGeneric.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise07;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class PrintArrayGeneric {
    public static <E> void printArray(E[] inputArray){
        for (E e: inputArray){
            System.out.printf("%s ", e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5, 6};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
        Character[] characters = {'H', 'E', 'L', 'L', 'O' };
        System.out.println("Mảng số nguyên:");
        printArray(integers);
        System.out.println("\nMảng số thực:");
        printArray(doubles);
        System.out.println("\nMảng kí tự:");
        printArray(characters);
    }
}
