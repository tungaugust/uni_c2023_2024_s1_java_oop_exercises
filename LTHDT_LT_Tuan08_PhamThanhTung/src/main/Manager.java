/*
 *  @ (#) Manager.java      1.0 19/09/2023
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
public class Manager extends SalariedEmployee{
    private double weeklyBonus;

    public Manager() {
        super();
        this.weeklyBonus = 0.0;
    }

    public Manager(String id, String name, LocalDate dob, double annualSalary, double weeklyBonus) {
        super(id, name, dob, annualSalary);
        setWeeklyBonus(weeklyBonus);
    }

    public double getWeeklyBonus() {
        return weeklyBonus;
    }

    public void setWeeklyBonus(double weeklyBonus) {
        this.weeklyBonus = weeklyBonus;
    }

    @Override
    public double weeklyPay() {
        return super.weeklyPay() + this.weeklyBonus;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String typeLine = "SalariedEmployee";
        return String.format("Employee Type: %s\nId: %s\nName: %s\nDate of birth: %s\nWeekly total salary: %s\n==Salary details==\nAnnual salary: %s",
                typeLine, getId(), getName(), getDob().format(dateTimeFormatter), decimalFormat.format(weeklyPay()), decimalFormat.format(annualSalary));
    }
}
