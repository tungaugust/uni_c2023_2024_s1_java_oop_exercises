/*
 *  @ (#) Employee.java       1.0 06/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise10;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 06, 2023
 */
public class Employee extends Person{
    public static final double SALARY_BASE = 2000000.0;
    private static final double SALARY_RATE = 1.0;
    private double salaryRate;

    public Employee() {
        this(null, null, SALARY_RATE);
    }

    public Employee(String name, String address, double salaryRate) {
        super(name, address);
        setSalaryRate(salaryRate);
    }

    public double getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(double salaryRate) {
        if(!(salaryRate > 0)){
            salaryRate = 1.0;
        }
        this.salaryRate = salaryRate;
    }

    @Override
    public String toString() {
        return String.format("%s | %.2f | %,.3f", super.toString(), getSalaryRate(), getSalary());
    }

    public double getSalary(){
        return SALARY_BASE * getSalaryRate();
    }

    @Override
    public String evaluate() {
        // Đánh giá nhân viên dựa trên lương nhận được
        double salaryAmount = getSalary();
        String evaluation;
        if (!(salaryAmount < 20000000.0)) {
            evaluation = "High income";
        } else if (!(salaryAmount < 10000000.0)) {
            evaluation = "Middle income";
        } else {
            evaluation = "Low income";
        }
        return evaluation;
    }
}
