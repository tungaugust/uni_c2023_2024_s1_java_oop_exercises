/*
 *  @ (#) Student.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise04;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class Student extends Person {
    private String studentID;   // mã số sinh viên
    private int yearMatriculated;   // năm nhập học

    public Student() {
        super("","");
        this.studentID = "chưa xác định";
        this.yearMatriculated = 9999;
    }

    public Student(String lastName, String firstName, String studentID, int yearMatriculated) {
        super(lastName, firstName);
        setStudentID(studentID);
        setYearMatriculated(yearMatriculated);
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getYearMatriculated() {
        return yearMatriculated;
    }

    public void setYearMatriculated(int yearMatriculated) {
        this.yearMatriculated = yearMatriculated;
    }
}
