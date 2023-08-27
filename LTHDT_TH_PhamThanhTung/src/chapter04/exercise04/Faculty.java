/*
 *  @ (#) Faculty.java      1.0 27/08/2023
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
public class Faculty extends Person {
    private String office;  // khoa
    private String facultyID;   // mã số giảng viên

    public Faculty() {
        super("","");
        this.office = "";
        this.facultyID = "";
    }

    public Faculty(String lastName, String firstName, String office, String facultyID) {
        super(lastName, firstName);
        setOffice(office);
        setFacultyID(facultyID);
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
    }
}
