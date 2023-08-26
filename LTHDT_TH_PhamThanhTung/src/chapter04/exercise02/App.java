/*
 *  @ (#) App.java      1.0 26/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise02;

import java.util.Calendar;
import java.util.Date;

/**
 * Lớp kiểm nghiệm
 * @author: tungpt
 * @version: 1.0
 * @since: August 26, 2023
 */
public class App {
    public static void main(String[] args) {
        Order order = new Order(1, new Date(2015, Calendar.SEPTEMBER, 10));

        Product product1 = new Product("sp1", "Gạo", 18000);
        Product product3 = new Product("sp3", "Đường", 10000);
        Product product4 = new Product("sp4", "Nước tương", 8000);

        order.addLineItem(product4, 10);
        order.addLineItem(product1, 5);
        order.addLineItem(product3, 1);
        order.addLineItem(product1, 1);

        System.out.println(order);
    }
}
