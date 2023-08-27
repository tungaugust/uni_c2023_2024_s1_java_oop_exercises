/*
 *  @ (#) ProjectLeader.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise03;

/**
 * Lớp ProjectLeader có kế thừa từ lớp Programmer (quan hệ Inheritance)
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class ProjectLeader extends Programmer{
    public ProjectLeader(int thePayrollNumber, String theName, double theBasicMonthlySalary, String theLanguage) {
        super(thePayrollNumber, theName, theBasicMonthlySalary, theLanguage);
    }

    @Override
    public double getMonthlySalary() {
        double ALLOWANCE_RATE = 0.2;
        return this.theBasicMonthlySalary * (1 + ALLOWANCE_RATE);
    }
}
