/*
 *  @ (#) ListOfLists.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise03;

import java.util.ArrayList;
import java.util.List;

/**
 * Nested generic type
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class ListOfLists {
    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<String>();
        listOfStrings.add("Hallo again");
        List<List<String>> listOfLists = new ArrayList<List<String>>();
        listOfLists.add(listOfStrings);
        String s = listOfLists.get(0).get(0);
        System.out.println(s);
    }
}
