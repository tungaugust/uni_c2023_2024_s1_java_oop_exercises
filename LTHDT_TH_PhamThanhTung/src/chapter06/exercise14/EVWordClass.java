/*
 *  @ (#) EVWordClass.java      1.0 11/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter06.exercise14;

import java.util.Objects;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 11, 2023
 */
public class EVWordClass implements Comparable{
    private String word;
    private String mean;
    private String type;
    private String notes;

    public EVWordClass() {
        this("", "", "", "");
    }

    public EVWordClass(String word, String mean, String type, String notes) {
        this.word = word;
        this.mean = mean;
        this.type = type;
        this.notes = notes;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EVWordClass that = (EVWordClass) o;
        return this.word.equalsIgnoreCase(that.getWord());
    }

    @Override
    public int compareTo(Object o) {
        return this.word.compareToIgnoreCase(((EVWordClass) o).getWord());
    }

    @Override
    public String toString() {
        return word + "; " + mean + "; " + type + "; " + notes;
    }
}
