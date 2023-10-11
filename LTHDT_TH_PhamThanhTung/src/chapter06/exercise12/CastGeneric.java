/*
 *  @ (#) CastGeneric.java      1.0 11/10/2023
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
public class CastGeneric {
    public static void main(String[] args) {
        Gen<Integer> intObject = new Gen<Integer>(88);
        Gen2<Long> longObject = new Gen2<Long>(99L);
//        longObject = (Gen2<Long>)intObject;
    }
}
