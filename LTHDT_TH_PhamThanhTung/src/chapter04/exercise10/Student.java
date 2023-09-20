/*
 *  @ (#) Student.java       1.0 06/09/2023
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
public class Student extends Person{
    private double score1;
    private double score2;

    public Student() {
        this(null,null, 0.0, 0.0);
    }

    public Student(String name, String address, double score1, double score2) {
        super(name, address);
        setScore1(score1);
        setScore2(score2);
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        if (score1 < 0 || score1 > 10) {
            score1 = 0.0;
        }
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        if (score2 < 0 || score2 > 10) {
            score2 = 0.0;
        }
        this.score2 = score2;
    }

    public double avarage() {
        return (score1 + score2) / 2;
    }

    @Override
    public String toString() {
        return String.format("%s | %.2f | %.2f | %.2f", super.toString(), getScore1(), getScore2(), avarage());
    }

    @Override
    public String evaluate() {
        // Đánh giá sinh viên dựa trên điểm trung bình
        double avarageScore = avarage();
        String evaluation;
        if (!(avarageScore < 8.5)) {
            evaluation = "A";
        } else if (!(avarageScore < 7.0)) {
            evaluation = "B";
        } else if (!(avarageScore < 5.5)) {
            evaluation = "C";
        } else if (!(avarageScore < 4.0)) {
            evaluation = "D";
        } else {
            evaluation = "F";
        }
        return evaluation;
    }
}
