/*
 *  @ (#) Student.java      1.0 01/11/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise10;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: November 01, 2023
 */
public class Student {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private double score;

    private Student(){
        this("XXXXXX", "No name", "No address", "No phone number", 0.0);
    }

    public Student(String id, String name, String address, String phoneNumber, double score) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%10s %25s %20s %15s %10.2f", id, name, address, phoneNumber, score);
    }
}
