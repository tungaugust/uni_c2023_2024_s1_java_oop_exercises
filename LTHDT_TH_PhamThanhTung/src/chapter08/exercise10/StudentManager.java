/*
 *  @ (#) StudentManager.java      1.0 01/11/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter08.exercise10;

import java.util.ArrayList;
import java.util.List;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: November 01, 2023
 */
public class StudentManager {
    private List<Student> list;

    public StudentManager() {
        this.list = new ArrayList<>();
    }
    public void add(Student student){
        this.list.add(student);
    }
    public void printAll(){
        this.list.stream().forEach(o -> System.out.println(o));
    }
}
