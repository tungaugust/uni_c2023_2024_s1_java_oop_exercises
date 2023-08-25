/*
 *  @ (#) CDList.java      1.0 25/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise05;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: August 25, 2023
 */
public class CDList {
    private CD[] cdList;
    private int count;

    public CDList() {
        this.cdList = new CD[10];
        this.count = 0;
    }

    public CDList(int n) {
        if (n > 0){
            this.cdList = new CD[n];
        } else {
            this.cdList = new CD[10];
        }
        this.count = 0;
    }

    public int getIndex(CD cd){
        long maCD = cd.getMaCD();
        for (int i = 0; i < this.count; i++) {
            if (this.cdList[i].getMaCD() == maCD) {
                return i;
            }
        }
        return -1;
    }
    public boolean add(CD cd){
        if ((this.count < this.cdList.length) && (getIndex(cd) < 0)) {
            this.cdList[this.count] = cd;
            this.count++;
            return true;
        }
        return false;
    }

    public int getSize(){
        return this.count;
    }

    public String totalPrice() {
        Locale locale = new Locale("vi", "vn");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        if (this.count == 0) {
            return numberFormat.format(0.0);
        }
        double sum = 0.0;
        for (int i = 0; i < this.count; i++) {
            sum += this.cdList[i].getGiaThanh();
        }
        return numberFormat.format(sum);
    }

    public void sortDescendingListByPrice() {
        if (this.count <= 1) {
            return;
        }
        Arrays.sort(this.cdList, 0, this.count,
                Comparator.comparing(CD::getGiaThanh).reversed()
        );
    }

    public void sortAscendingListByTitle() {
        if (this.count <= 1) {
            return;
        }
        Arrays.sort(this.cdList, 0, this.count,
                Comparator.comparing(CD::getTuaCD)
        );
    }

    public void printList() {
        for (int i = 0; i < this.count; i++) {
            System.out.printf("%-5d | %s\n", i+1, this.cdList[i]);
        }
    }
}
