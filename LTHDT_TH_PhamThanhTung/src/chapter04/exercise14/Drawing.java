/*
 *  @ (#) Drawing.java      1.0 28/08/2023
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
public class Drawing {
    public static void drawShape(Shape theShape) {
        theShape.draw();
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape quad = new Quad();
        Shape polygon = new Polygon();
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();

        drawShape(circle);
        drawShape(quad);
        drawShape(polygon);
        drawShape(rectangle);
        drawShape(triangle);
    }
}
