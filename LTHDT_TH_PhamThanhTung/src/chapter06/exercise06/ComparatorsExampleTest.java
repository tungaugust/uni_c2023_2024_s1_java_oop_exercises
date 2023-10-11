/*
 *  @ (#) ComparatorsExampleTest.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise06;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
class ComparatorsExample {
    public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
        T candidate = coll.iterator().next();
        for (T elt: coll) {
            if (cmp.compare(candidate, elt) < 0) {
                candidate = elt;
            }
        }
        return candidate;
    }
    public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll){
        return max(coll, ComparatorsExample.<T> naturalOrder());
    }
    public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp){
        return max(coll, reverseOrder(cmp));
    }
    public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll){
        return max(coll, ComparatorsExample.<T> reverseOrder());
    }
    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder(){
        return new Comparator<T>(){
            public int compare(T o1, T o2){
                return o1.compareTo(o2);
            }
        };
    }
    public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp){
        return new Comparator<T>() {
            public int compare(T o1, T o2){
                return cmp.compare(o2, o1);
            }
        };
    }
    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder(){
        return new Comparator<T>() {
            public int compare(T o1, T o2){
                return o2.compareTo(o1);
            }
        };
    }
}

public class ComparatorsExampleTest {
    public static void main(String[] args) {
        Comparator<String> sizeOrder = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() < o2.length() ? -1 : o1.length() > o2.length() ? 1 : o1.compareTo(o2);
            }
        };
        Collection<String> strings = Arrays.asList("AAA", "aaa", "CCC", "f");
        System.out.println(ComparatorsExample.max(strings));
        System.out.println(ComparatorsExample.min(strings));
        System.out.println(ComparatorsExample.max(strings, sizeOrder));
        System.out.println(ComparatorsExample.min(strings, sizeOrder));
    }
}
