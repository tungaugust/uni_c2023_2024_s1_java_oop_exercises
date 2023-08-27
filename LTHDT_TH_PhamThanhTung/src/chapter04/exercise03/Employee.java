/*
 *  @ (#) Employee.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise03;

/**
 * Lớp Employee là lớp bị phụ thuộc bởi lớp SoftwareHouse (quan hệ Dependency)
 * Lớp Employee được lớp Programmer và Administrator kế thừa (quan hệ Inheritance)
 * Lớp Employee là là một phần của lớp SoftwareHouse (quan hệ Aggregation)
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public abstract class Employee {
    protected int thePayrollNumber;
    protected String theName;
    protected double theBasicMonthlySalary;

    public Employee(int thePayrollNumber, String theName, double theBasicMonthlySalary) {
        if (theBasicMonthlySalary < 0) {
            theBasicMonthlySalary = 0.0;
        }
        if (theName.equals("")) {
            theName = "chưa xác định";
        }
        if (thePayrollNumber < 0) {
            thePayrollNumber = 0;
        }
        this.thePayrollNumber = thePayrollNumber;
        this.theName = theName;
        this.theBasicMonthlySalary = theBasicMonthlySalary;
    }

    public abstract double getMonthlySalary();

    @Override
    public abstract String toString();
}
