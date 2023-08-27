/*
 *  @ (#) SoftwareHouse.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lớp SoftwareHouse có kế thừa từ Employee (quan hệ Inheritance)
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class SoftwareHouse {
    private String theName;
    private List<Employee> listStaff;

    public SoftwareHouse(String aName) {
        this.theName = aName;
        this.listStaff = new ArrayList<>();
    }
    public boolean addEmployee(Employee emp) {
        for (Employee e: this.listStaff) {
            if(e.thePayrollNumber == emp.thePayrollNumber) {
                return false;
            }
        }
        this.listStaff.add(emp);
        return true;
    }
    public void displayAllStaff(){
        for (int i = 0; i < this.listStaff.size(); i++) {
            System.out.printf("%-5d | %s\n", i + 1, this.listStaff.get(i));
        }
    }
    public double getMonthlySalaryBill(){
        double sum = 0.0;
        for (Employee emp: this.listStaff) {
            sum += emp.getMonthlySalary();
        }
        return sum;
    }
    public void sortAllStaffByName(){
        Collections.sort(this.listStaff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int comparisonResult = o1.theName.compareTo(o2.theName);
                if (comparisonResult > 0) {
                    return 1;
                } else if (comparisonResult < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
    public void displayListProgrammers(){
        for (int i = 0; i < this.listStaff.size(); i++) {
            if (this.listStaff.get(i) instanceof Programmer) {
                System.out.printf("%-5d | %s\n", i + 1, this.listStaff.get(i));
            }
        }
    }
    public boolean updateDepartmentForAdmin(int aPayrollNo, String deptNew) {
        for (Employee emp: this.listStaff) {
            if (emp.thePayrollNumber == aPayrollNo) {
                Administrator admin = (Administrator) emp;
                admin.setTheDepartment(deptNew);
                return true;
            }
        }
        return false;
    }
}
