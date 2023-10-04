/*
 *  @ (#) DiaChi.java      1.0 04/10/2023
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
public class DiaChi {
    private String diaChi;

    public DiaChi(String diaChi) {
        setDiaChi(diaChi);
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return String.format("Địa chỉ [\"%s\"]", getDiaChi());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaChi diaChiKhac = (DiaChi) o;
        return this.diaChi.equalsIgnoreCase(diaChiKhac.getDiaChi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(diaChi.toLowerCase());
    }
}
