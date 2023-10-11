/*
 *  @ (#) SoDienThoai.java      1.0 04/10/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise07;

import java.util.Objects;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: October 04, 2023
 */
public class SoDienThoai {
    private String soDienThoai;

    public <T> SoDienThoai(T soDienThoai) {
        setSoDienThoai(soDienThoai);
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public <T> void setSoDienThoai(T soDienThoai) {
        this.soDienThoai = String.valueOf(soDienThoai);
        if (this.soDienThoai.equalsIgnoreCase("")) {
            this.soDienThoai = "0001110000";
        }
        if (!this.soDienThoai.startsWith("0")){
            this.soDienThoai = "0" + this.soDienThoai;
        }
    }

    @Override
    public String toString() {
        return String.format("Số điện thoại [%s]", getSoDienThoai());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoDienThoai that = (SoDienThoai) o;
        return this.soDienThoai.equalsIgnoreCase(that.getSoDienThoai());
    }

    @Override
    public int hashCode() {
        return Objects.hash(soDienThoai.toLowerCase());
    }
}
