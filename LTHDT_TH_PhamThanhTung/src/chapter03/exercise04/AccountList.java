/*
 *  @ (#) AccountList.java      1.0 24/08/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter03.exercise04;

/**
 * Lớp chưa danh sách các đối tượng Account
 * @author: tungpt
 * @version: 1.0
 * @since: August 24, 2023
 */
public class AccountList {
    private Account[] accList;
    private int count;

    public AccountList() {
        this.accList = new Account[10];
        this.count = 0;
    }

    public AccountList(int n) {
        if (n > 0) {
            this.accList = new Account[n];
        } else {
            this.accList = new Account[10];
        }
        this.count = 0;
    }

    public boolean add(Account account){
//        n=5: 0 1 2 3 4
//        c=4, 5
        if (this.count < this.accList.length) {
            this.accList[this.count] = account;
            this.count++;
            return true;
        }
        return false;
    }

    public Account find(long accID){
        for (int i = 0; i < this.count; i++) {
            if (this.accList[i].getSoTaiKhoan() == accID){
                return this.accList[i];
            }
        }
        return null;
    }

    public boolean remove(long accID){
        for (int i = 0; i < this.count; i++) {
            if (this.accList[i].getSoTaiKhoan() == accID) {
                for (int j = i; j < this.count; j++) {
                    this.accList[j] = this.accList[j + 1];
                }
                this.accList[this.count - 1] = null;
                this.count--;
                return true;
            }
        }
        return false;
    }

    public int getSize(){
        return this.count;
    }

    public void printAccountList(){
        for (int i = 0; i < this.count; i++) {
            System.out.printf("%-5d | %s\n", i+1, this.accList[i]);
        }
    }
}
