/*
 *  @ (#) GenericClass.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise01;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class GenericClass <T> {
    private T obj;
    GenericClass(T obj){
        this.obj = obj;
    }
    public T getObj() {
        return this.obj;
    }
    public void showType() {
        System.out.println("Kiểu của T là " + obj.getClass().getName());
    }
}
