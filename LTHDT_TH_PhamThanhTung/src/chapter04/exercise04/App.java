/*
 *  @ (#) App.java      1.0 27/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise04;

import java.util.HashSet;
import java.util.Set;

/**
 * Quản lý thông tin các khóa học và thông tin sinh viên tham gia đăng ký học các khóa học
 * @author: tungpt
 * @version: 1.0
 * @since: August 27, 2023
 */
public class App {
    public static void main(String[] args) {
        // 1. Tạo danh sách giảng viên
        Person faculty1 = new Faculty("Lê Kim", "Khánh","CNTT", "F001");
        Person faculty2 = new Faculty("Văn Chí", "Tâm","CNTT", "F002");

        // 2. Tạo danh sách sinh viên
        Person student1 = new Student("Hoàng", "Dũng","140211", 2014);
        Person student2 = new Student("Trần", "Bình","140511", 2014);
        Person student3 = new Student("Lê", "Huynh","140811", 2014);
        Person student4 = new Student("Hồ", "Huyền","140611", 2014);
        Person student5 = new Student("Dương", "Phi","140311", 2014);
        Person student6 = new Student("Hoàng", "Phương","140711", 2014);
        Person student7 = new Student("Phan", "Huy","140111", 2014);

        // 4. Lập danh sách sinh viên tham gia vào 1 học phần của khóa học do 1 giảng viên giảng dạy.
        Enrolment enrolment1 = new Enrolment((Student) student1, "qua môn", "A", 8.5f);
        Enrolment enrolment2 = new Enrolment((Student) student2, "qua môn", "A+", 9.5f);
        Enrolment enrolment3 = new Enrolment((Student) student3, "qua môn", "B", 7.0f);
        Enrolment enrolment4 = new Enrolment((Student) student4, "qua môn", "C", 5.5f);
        Enrolment enrolment6 = new Enrolment((Student) student5, "qua môn", "B+", 7.5f);
        Enrolment enrolment7 = new Enrolment((Student) student6, "qua môn", "A-", 8.0f);
        Enrolment enrolment8 = new Enrolment((Student) student7, "học lại", "C-", 4.5f);

        Set<Enrolment> listEnrolls1 = new HashSet<>();
        listEnrolls1.add(enrolment1);
        listEnrolls1.add(enrolment2);
        listEnrolls1.add(enrolment3);
        listEnrolls1.add(enrolment4);
        Set<Enrolment> listEnrolls2 = new HashSet<>();
        listEnrolls2.add(enrolment6);
        listEnrolls2.add(enrolment7);
        listEnrolls2.add(enrolment8);

        // 3. Tạo khóa học.
        Course course1 = new Course("1516011001", "OOP - Lập trình hướng đối tượng", 4);
        course1.addSection("0602", "I (2015 - 2016)", "H5.01", (Faculty) faculty1, listEnrolls1);
        course1.addSection("0605", "I (2015 - 2016)", "H5.02", (Faculty) faculty2, listEnrolls2);

        // 5. In ra màn hình theo mẫu
        System.out.printf("Khoá học: [%s (%dTC)]\n", course1.getCourseTitle(), course1.getCredits());
        System.out.println("\t===== Thông tin học phần =====");
        String maHocPhan = "0602";
        String headerLine = String.format("\t%-10s %-20s %10s %10s", "Mã SV", "Họ tên", "Khoá năm", "Điểm");
        for (Section section: course1.getSections()){
            if (section.getSectionNbr().equals(maHocPhan)){
                System.out.println("\tMã học phần: " + section.getSectionNbr());
                System.out.println("\tHọc kỳ: " + section.getSemester());
                System.out.println("\tPhòng học: " + section.getRoom());
                System.out.println("\tGiảng viên: "
                        + section.getFacultyMember().getLastName()
                        + " " + section.getFacultyMember().getFirstName()
                        + " (Khoa : " + section.getFacultyMember().getOffice() + ")"
                );
                System.out.println("\t===== Danh sách sinh viên =====");
                System.out.println(headerLine);
                Student student;
                for (Enrolment enrolment: section.getListEnrolls()) {
                    student = enrolment.getStudent();
                    System.out.println(String.format("\t%-10s %-20s %10d %10.1f",
                            student.getStudentID(),
                            student.getLastName() + " " + student.getFirstName(),
                            student.getYearMatriculated(),
                            enrolment.getNumGrade()));
                }
                break;
            }
        }
        System.out.println("\n\tTổng số sinh viên: " + course1.getNbrStudents(maHocPhan));

        //
    }
}
