/*
 *  @ (#) HourlyEmployee.java      1.0 19/09/2023
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
public class HourlyEmployee extends Employee {
    private int hoursWorked;
    private double hourlyWage;

    public HourlyEmployee() {
        super();
        this.hoursWorked = 0;
        this.hourlyWage = 0.0;
    }

    public HourlyEmployee(String id, String name, LocalDate dob, int hoursWorked, double hourlyWage) {
        super(id, name, dob);
        setHoursWorked(hoursWorked);
        setHourlyWage(hourlyWage);
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public double weeklyPay() {
        if (this.hoursWorked > 40) {
            return this.hourlyWage*(40 + 1.5*(this.hoursWorked - 40));
        }
        return this.hourlyWage*this.hoursWorked;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
        String typeLine = "HourlyEmployee";
        return String.format("Employee Type: %s\n%s\nWeekly total salary: %s\n==Salary details==\nHours worked: %d\nHourly wage: %s",
                typeLine, super.toString(), decimalFormat.format(weeklyPay()), hoursWorked, decimalFormat.format(hourlyWage));
    }
}
