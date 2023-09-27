/*
 *  @ (#) CustomerList.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public class CustomerList {

    private List<Customer> customerList;

    public CustomerList() {
        this.customerList = new ArrayList<>();
    }

    public boolean addCustomer(String id, String name, double saleValue) {
        return addCustomer(new Customer(id, name, saleValue));
    }

    public boolean addCustomer(Person customer){
        if(customerList.contains(customer)) {
            return false;
        }
        customerList.add((Customer) customer);
        return true;
    }

    public void sortCustomerListBySaleValue() {
        this.customerList =  this.customerList.stream()
                .sorted(Comparator.comparing(Customer::getSaleValue))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void printList(){
        printList(this.customerList);
    }

    public void printList(List<Customer> list){
        list.stream().forEach(o -> System.out.println(o));
    }
}
