/*
 *  @ (#) Enrolment.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise04;

/**
 * Lớp Enrolment là lớp thể hiển sự than gia mỗi lớp học phần (lớp Section) của mỗi sinh viên (lớp Student)
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class Enrolment {
    private Student student;    // đối tượng sinh viên
    private String status;  // trạng thái
    private String grade;   // điễm chữ
    private float numGrade; // điễm số

    public Enrolment(Student student, String status, String grade, float numGrade) {
        this.student = student;
        setStatus(status);
        setGrade(grade);
        setNumGrade(numGrade);
    }

    public Student getStudent() {
        return student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public float getNumGrade() {
        return numGrade;
    }

    public void setNumGrade(float numGrade) {
        this.numGrade = numGrade;
    }
}
