/*
 *  @ (#) EmployeeList.java      1.0 19/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

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
        this(10);
    }

    public EmployeeList(int size) {
        if (size <= 0) {
            size = 10;
        }
        this.currentSize = size;
        this.employees = new Employee[this.currentSize];
    }

    public Employee[] getEmployees() {
        return Arrays.stream(this.employees, 0, this.currentSize).filter(emp -> emp != null).toArray(x -> new Employee[x]);
    }

    public void addEmployee(Employee emp) {
        int index  = indexOfEmployee(emp.getId());
        if (index >= 0) {
            throw new IllegalArgumentException("Nhân viên có số ID là \'" + emp.getId() + "\' đã tồn tại");
        }
        if (this.employees[this.currentSize - 1] != null) {
            grow();
        }
        for (int i = 0; i < this.currentSize; i++) {
            if (this.employees[i] == null){
                this.employees[i] = emp;
                break;
            }
        }
    }
    public void addAll(Employee[] emps){
        for (int i = 0; i < emps.length; i++) {
            try {
                addEmployee(emps[i]);
            } catch (IllegalArgumentException e){}
        }
    }

    private int indexOfEmployee(String id) {
        for (int i = 0; i < this.currentSize; i++) {
            if (this.employees[i] == null) {
                break;
            }
            if (this.employees[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Employee searchEmployeeById(String id) {
        int index = indexOfEmployee(id);
        if (index < 0) {
            return null;
        }
        return this.employees[index];
    }

    private void grow(){
        int newLength = (int) Math.ceil(this.currentSize*1.5);
        this.employees = Arrays.copyOf(this.employees, newLength);
        this.currentSize = newLength;
    }

    public void sortByWeeklySalary() {
        Arrays.sort(this.employees, Comparator.comparing(Employee::weeklyPay));
    }

    public void removeEmployee(String id){
        Employee[] filterd = Arrays.stream(this.employees, 0, this.currentSize)
                .filter(emp -> !emp.getId().equals(id))
                .toArray(x -> new Employee[x]);
        this.employees = Arrays.copyOf(filterd, this.currentSize);
    }

    public void updateEmployee(Employee newInfor) {
        int index = indexOfEmployee(newInfor.getId());
        if (index < 0) {
            throw new IllegalArgumentException("Nhân viên có số ID là \'" + newInfor.getId() + "\' đã tồn tại");
        }
        this.employees[index] = newInfor;
    }

    public Employee[] getHourlyEmpsWorkMoreThan40(){
        return Arrays.stream(this.employees, 0, this.currentSize)
                .filter(emp -> (emp instanceof HourlyEmployee) && ((HourlyEmployee) emp).getHoursWorked() > 40)
                .toArray(x -> new Employee[x]);
    }
    public double getWeeklyTotalSalaryOfManager(){
         return Arrays.stream(this.employees, 0, this.currentSize)
                 .filter(emp -> emp instanceof Manager)
                 .map(emp -> ((Manager) emp).weeklyPay())
                 .reduce(0.0, Double::sum); // (a,b) -> a + b
    }

    public void updateHourlyWorked (String id, int newHour) {
        if (newHour < 0) {
            throw new IllegalArgumentException("Giờ làm việc không thể nhỏ hơn 0");
        }
        int index = indexOfEmployee(id);
        if (index < 0) {
            throw new IllegalArgumentException("Nhân viên có số ID là \'" + id + "\' đã tồn tại");
        }
        if (this.employees[index] instanceof HourlyEmployee) {
            ((HourlyEmployee) this.employees[index]).setHoursWorked(newHour);
        } else {
            throw new IllegalArgumentException("Nhân viên có số ID là \'" + id + "\' không là nhân viên theo giờ");
        }
    }

    public Employee[] getYoungEmployeesAsManagers(){
        return Arrays.stream(this.employees, 0, this.currentSize)
                .filter(emp -> (emp instanceof Manager)
                        && (LocalDate.now().getYear() - emp.getDob().getYear() < 30))
                .toArray(x -> new Employee[x]);
    }
}
