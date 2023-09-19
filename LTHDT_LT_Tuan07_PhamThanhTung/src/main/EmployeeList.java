/*
 *  @ (#) EmployeeList.java      1.0 19/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 19, 2023
 */
public class EmployeeList {
    private int currentSize;
    private Employee[] employees;

    public EmployeeList() {
        this.employees = new Employee[10];
    }

    public EmployeeList(int size) {
        this.currentSize = size;
        this.employees = new Employee[this.currentSize];
    }

    public Employee[] getEmployees() {
        return employees;
    }

}
