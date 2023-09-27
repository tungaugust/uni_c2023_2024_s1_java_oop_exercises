/*
 *  @ (#) Person.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise01;

import java.util.Objects;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public abstract class Person {
    private String id;
    private String name;


    public Person() {
        this("No ID", "No name");
    }
    public Person(String id, String name) {
        setId(id);
        setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", id, name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }

    @Override
    public boolean equals(Object obj) {
        // Đối tượng so sánh với chính nó
        if (this == obj) return true;

        // Đối tượng là NULL hoặc có lớp khác
        if (obj == null
                || this.getClass() != obj.getClass()
        ) return false;

        // Typecasting đối tượng
        Person that = (Person) obj;
        return this.getId().equalsIgnoreCase(that.getId());
    }
}
