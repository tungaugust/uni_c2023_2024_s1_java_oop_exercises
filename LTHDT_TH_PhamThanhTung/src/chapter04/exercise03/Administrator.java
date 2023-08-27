/*
 *  @ (#) Administrator.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise03;

import java.text.DecimalFormat;

/**
 * Lớp Administrator có kế thừa từ Employee (quan hệ Inheritance)
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class Administrator extends Employee{
    private String theDepartment;

    public Administrator(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theDepartment) {
        super(thePayrollNumber, theName, theBasicMonthlySalary);
        this.theDepartment = theDepartment;
    }

    void setTheDepartment(String theDepartment) {
        this.theDepartment = theDepartment;
    }

    @Override
    public double getMonthlySalary() {
        double ALLOWANCE_RATE = 0.4;
        return this.theBasicMonthlySalary * (1 + ALLOWANCE_RATE);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("$#,##0");
        return String.format("%-10d | %-25s | %-15s | %15s",
                this.thePayrollNumber,
                this.theName,
                decimalFormat.format(this.theBasicMonthlySalary),
                this.theDepartment
        );
    }
}
