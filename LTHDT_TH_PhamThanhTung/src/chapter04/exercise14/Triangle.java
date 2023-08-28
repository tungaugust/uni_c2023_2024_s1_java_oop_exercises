/*
 *  @ (#) Triangle.java      1.0 28/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise14;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 28, 2023
 */
public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("To draw a triangle");
    }

    @Override
    public void erase() {
        System.out.println("To erase a triangle");
    }

    @Override
    public void move(int x, int y) {
        System.out.println("To move a triangle");
    }
}
