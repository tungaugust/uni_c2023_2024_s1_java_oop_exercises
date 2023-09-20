/*
 *  @ (#) Person.java       1.0 06/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise10;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 06, 2023
 */
public abstract class Person {
    private String name;
    private String address;

    public Person() {
        this(null, null);
    }

    public Person(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.equals("")) {
            name = "No name";
        }
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null || address.equals("")) {
            address = "No location";
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s | %s", name, address);
    }

    public abstract String evaluate();
}
