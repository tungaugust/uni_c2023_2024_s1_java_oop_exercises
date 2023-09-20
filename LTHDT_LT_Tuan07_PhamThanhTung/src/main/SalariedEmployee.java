/*
 *  @ (#) SalariedEmployee.java      1.0 19/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main;

import java.text.DecimalFormat;
import java.time.LocalDate;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 19, 2023
 */
public class SalariedEmployee extends Employee{
    protected double annualSalary;

    public SalariedEmployee() {
        super();
        this.annualSalary = 0.0;
    }

    public SalariedEmployee(String id, String name, LocalDate dob, double annualSalary) {
        super(id, name, dob);
        setAnnualSalary(annualSalary);
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double weeklyPay() {
        return this.annualSalary/52;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
        String typeLine = "SalariedEmployee";
        return String.format("Employee Type: %s\n%s\nWeekly total salary: %s\n==Salary details==\nAnnual salary: %s",
                typeLine, super.toString(), decimalFormat.format(weeklyPay()), decimalFormat.format(annualSalary));
    }
}
