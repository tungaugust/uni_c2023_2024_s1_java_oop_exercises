/*
 *  @ (#) EmployeeList.java      1.0 27/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package chapter05.exercise01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 27, 2023
 */
public class EmployeeList {
    private List<Person> employeeList;
    private List<String> nameList;
    private Set<String> usedNameSet;
    private List<Person> registeredEmployeeList;

    public EmployeeList() {
        this.employeeList = new ArrayList<>();
        this.nameList = new ArrayList<>();
        this.usedNameSet = new HashSet<>();
        this.registeredEmployeeList = new ArrayList<>();
    }

    public boolean addEmployee(String id, String name){
        return addEmployee(new Employee(id, name));
    }
    public boolean addEmployee(Person employee){
        if (employeeList.contains(employee)){
            return false;
        }
        employeeList.add(employee);
        return true;
    }

    private List<String> getNameSet(){
        return this.nameList = this.employeeList.stream()
                .map(o -> o.getName())
                .collect(Collectors.toCollection(
                        () -> new ArrayList<>()
                ));
    }

    public Employee choiceRandomEmployee(){
        return (Employee) this.employeeList.get(new Random().nextInt(this.employeeList.size()));
    }

    public String choiceNameForNewProduct(){
        Set<String> nameSet = getNameSet().stream()
                .collect(Collectors.toCollection(
                        () -> new HashSet<>()
                ));
        String randomName = nameSet.stream()
                .filter(o -> !this.usedNameSet.contains(o))
                .skip(new Random().nextInt(nameSet.size()))
                .findFirst()
                .orElse(null);
        this.usedNameSet.add(randomName);
        return randomName;
    }

    public String findPopularName(){
        Map<String, Long> map = this.nameList.stream()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));
        Long max = map.values().stream().max(Comparator.comparing(o -> o)).get();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void register(String id){
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            this.registeredEmployeeList.add(employee);
        }
    }

    public void printRegisteredEmployeeList(){
        printList(this.registeredEmployeeList);
    }

    private Employee getEmployeeById(String id){
        return this.employeeList.stream()
                .map(o -> (Employee) o)
                .filter(o -> o.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public void printList(){
        printList(this.employeeList);
    }
    public void printList(List<Person> list){
        list.stream().forEach(o -> System.out.println(o));
    }
}