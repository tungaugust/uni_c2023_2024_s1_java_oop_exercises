/*
 *  @ (#) TwoGenerics.java      1.0 11/10/2023
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
public class TwoGenerics<T, V> {
    private T obj1;
    private V obj2;

    public TwoGenerics(T obj1, V obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void showType(){
        System.out.println("The type of T is " + obj1.getClass().getName());
        System.out.println("The type of V is " + obj2.getClass().getName());
    }

    public T getObj1() {
        return obj1;
    }

    public V getObj2() {
        return obj2;
    }
}
