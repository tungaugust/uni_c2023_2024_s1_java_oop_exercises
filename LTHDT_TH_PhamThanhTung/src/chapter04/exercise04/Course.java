/*
 *  @ (#) Course.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise04;

import java.util.HashSet;
import java.util.Set;

/**
 * Lớp Course là lớp chứa các học phần đăng kí của mỗi môn học
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class Course {
    private String courseNbr;
    private String courseTitle;
    private int credits;
    private Set<Section> sections;

    public Course() {
        this.courseNbr = "";
        this.courseTitle = "";
        this.credits = 0;
        this.sections = new HashSet<>();
    }
    public Course(String courseNbr, String courseTitle, int credits) {
        setCourseNbr(courseNbr);
        setCourseTitle(courseTitle);
        setCredits(credits);
        this.sections = new HashSet<>();
    }

    public int getNbrStudents(String sectionNbr){
        for (Section section: this.sections) {
            if (section.getSectionNbr().equals(sectionNbr)) {
                return section.getListEnrolls().size();
            }
        }
        return 0;
    }
    public void addSection(String sectionNbr, String semester, String room,
                           Faculty facultyMember, Set<Enrolment> listEnrolls){
        Section section = new Section(sectionNbr, semester, room, facultyMember, listEnrolls);
        this.sections.add(section);
    }

    public Set<Section> getSections() {
        return sections;
    }

    public String getCourseNbr() {
        return courseNbr;
    }

    public void setCourseNbr(String courseNbr) {
        this.courseNbr = courseNbr;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
