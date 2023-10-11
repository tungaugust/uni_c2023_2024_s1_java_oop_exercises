/*
 *  @ (#) Person.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise04;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class Person implements Comparable<Person>{
    private String firstName;
    private String surname;

    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return firstName + " " + surname;
    }

    @Override
    public int compareTo(Person person) {
        int result = surname.compareTo(person.surname);
        return result == 0 ? firstName.compareTo(((Person) person).firstName) : result;
    }
}
