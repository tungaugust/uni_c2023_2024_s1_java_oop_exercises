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
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public abstract double weeklyPay();

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
        return String.format("Id: %s\nName: %s\nDate of birth: %s\nWeekly total salary: %s",
                id, name, dob.format(dateTimeFormatter), decimalFormat.format(weeklyPay()));
    }
}
