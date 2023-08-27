/*
 *  @ (#) Person.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise04;

/**
 * Lớp Person chứa các thông tin cơ bản (họ và tên)
 * và được lớp sinh viên Student và giảng viên Faculty kế thừa
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class Person {
    protected String lastName;  // họ
    protected String firstName; // tên

    public Person() {
        this.lastName = "";
        this.firstName = "";
    }

    public Person(String lastName, String firstName) {
        setLastName(lastName);
        setFirstName(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
