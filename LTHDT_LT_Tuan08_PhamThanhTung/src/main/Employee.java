/*
 *  @ (#) Employee.java      1.0 19/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 19, 2023
 */
public abstract class Employee {
    protected String id;
    protected String name;
    protected LocalDate dob;

    public Employee() {
        this("", "", LocalDate.now());
    }

    public Employee(String id, String name, LocalDate dob) {
        setId(id);
        setName(name);
        setDob(dob);
    }

    public abstract double weeklyPay();

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Id: %s\nName: %s\nDate of birth: %s",
                id, name, dob.format(dateTimeFormatter));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return this.id.equalsIgnoreCase(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
