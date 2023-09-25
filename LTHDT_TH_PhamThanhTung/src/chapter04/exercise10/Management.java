/*
 *  @ (#) Management.java       1.0 06/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter04.exercise10;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 06, 2023
 */
public class Management {
    private Person[] people;
    private int count;

    public Management() {
        this.people = new Person[5];
        this.count = 0;
    }

    public Person[] getPeople() {
        return Arrays.stream(this.people, 0, this.count)
                .toArray(o -> new Person[o]);
    }

    public int getCount() {
        return count;
    }

    private int index(String name){
        for (int i = 0; i < this.count; i++) {
            if (this.people[i] == null) {
                break;
            }
            if (this.people[i].getName().toLowerCase().equals(name.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }
    private void grow(){
        int newLength = (int) Math.ceil(this.people.length * 1.5);
        this.people = Arrays.copyOf(this.people, newLength);
    }
    public void add(Person person){
        if(this.count >= this.people.length){
            grow();
        }
        this.count++;
        this.people[this.count - 1] = person;
    }


    public void remove(String name){
        this.people = Arrays.stream(this.people, 0, this.count)
                .filter(o -> !o.getName().toLowerCase().equals(name.toLowerCase()))
                .toArray(o -> new Person[o]);
        this.count = this.people.length;
    }

    public void sortByOrderdName(){
        Arrays.sort(this.people, 0, this.count, Comparator.comparing(Person::getName));
    }

    public void printPersonList(){
        Arrays.stream(this.people, 0, this.count).forEach(o -> System.out.println(o));
    }
}
