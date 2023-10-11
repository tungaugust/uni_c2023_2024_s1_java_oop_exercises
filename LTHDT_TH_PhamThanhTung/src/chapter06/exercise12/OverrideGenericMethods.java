/*
 *  @ (#) OverrideGenericMethods.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise12;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */

class Gen<T> {
    T obj;

    Gen(T obj) {
        this.obj = obj;
    }

    T getObject() {
        System.out.println("Gen's getObject(): " );
        return obj;
    }
}

class Gen2<T> extends Gen<T> {
    Gen2(T obj){
        super(obj);
    }

    T getObject() {
        System.out.println("Gen2's getObject(): " );
        return obj;
    }
}
public class OverrideGenericMethods {
    public static void main(String[] args) {
        Gen<Integer> intObject = new Gen<Integer>(88);
        Gen2<Long> longObject = new Gen2<Long>(99L);
        intObject.getObject();
        longObject.getObject();
    }
}
