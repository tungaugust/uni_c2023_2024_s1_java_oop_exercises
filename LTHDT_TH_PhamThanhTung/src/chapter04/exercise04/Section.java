/*
 *  @ (#) Section.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise04;

import java.util.HashSet;
import java.util.Set;

/**
 * Lớp Section là lớp học phần
 * @version: 1.0
 * @since: August 27, 2023
 */
public class Section {
    private String sectionNbr;  // mã số học phần
    private String semester;    // học kì mở lớp
    private String room;    // phòng học
    private Faculty facultyMember;  // giảng viên phụ trách
    private Set<Enrolment> listEnrolls; // danh sách các đăng kí tham gia (lớp Enrolment) học phàn của các sinh viên

    public Section() {
        this.sectionNbr = "";
        this.semester = "";
        this.room = "";
        this.facultyMember = null;
        this.listEnrolls = new HashSet<>();
    }

    public Section(String sectionNbr, String semester, String room, Faculty facultyMember, Set<Enrolment> listEnrolls) {
        setSectionNbr(sectionNbr);
        setSemester(semester);
        setRoom(room);
        this.facultyMember = facultyMember;
        this.listEnrolls = listEnrolls;
    }

    public Faculty getFacultyMember() {
        return facultyMember;
    }

    public Set<Enrolment> getListEnrolls() {
        return listEnrolls;
    }

    public String getSectionNbr() {
        return sectionNbr;
    }

    public void setSectionNbr(String sectionNbr) {
        this.sectionNbr = sectionNbr;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
