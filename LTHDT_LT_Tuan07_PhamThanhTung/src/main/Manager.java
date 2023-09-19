/*
 *  @ (#) Manager.java      1.0 19/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main;

import java.time.LocalDate;

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


}
