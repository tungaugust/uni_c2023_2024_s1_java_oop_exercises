/*
 *  @ (#) EmployeeList.java      1.0 19/09/2023
 *
 *  Copyright (c) 2023 IUH.
 *  All rights reserved.
 */

package main;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @description
 * @author: tungpt
 * @version: 1.0
 * @since: September 19, 2023
 */
public class EmployeeList {
    private Set<Employee> employees;

    // Default constructor
    public EmployeeList() {
        this.employees = new HashSet<>();
    }

    // Trả về danh sách toàn bộ các nhân viên
    public Set<Employee> getEmployees() {
        return this.employees;
    }

    // Thêm 1 nhân viên vào danh sách, thêm không trùng mã số nhân viên
    public boolean addEmployee(Employee emp) {
        if (employees.contains(emp)) {
            return false;
        }
        this.employees.add(emp);
        return true;
    }

    // Thêm một danh sách các nhân viên mới vào danh sách có trước, vẫn đảm bảo không bị trùng mã số nhân viên
    public void addAll(Set<Employee> emps){
        emps.forEach(o -> addEmployee(o));
    }

    // Tìm kiếm nhân viên khi biết mã số. Trả về null, nếu không tìm thấy
    public Employee searchEmployeeById(String id) {
        return this.employees.stream()
                .filter(o -> o.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    // Sắp xếp danh sách nhân viên theo lương tuần tăng dần, trả về danh sách sau khi sắp xếp
    public List<Employee> sortByWeeklySalary() {
        return this.employees.stream()
                .sorted(Comparator.comparing(Employee::weeklyPay))
                .collect(Collectors.toCollection(
                        () -> new ArrayList<>()
                ));
    }

    // Trích ra năm sinh của nhân viên, kết quả không trùng và sắp xếp giảm dần
    public Set<Integer> getYOBSet(){
        return this.employees.stream()
                .map(o -> o.getDob().getYear())
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>()
                )).descendingSet();
    }

    // Xóa 1 nhân viên khi biết mã số
    public boolean removeEmployee(String id){
        Employee employee = searchEmployeeById(id);
        if (employee == null) {
            return false;
        }
//        this.employees = this.employees.stream()
//                .filter(o -> !o.getId().equalsIgnoreCase(id))
//                .collect(Collectors.toCollection(
//                        () -> new HashSet<>()
//                ));
        this.employees.remove(employee);
        return true;
    }

    // Cập nhật thông tin của nhân viên khi biết mã số (dùng chung 1 phương thức cho cả 3 loại nhân viên)
    public boolean updateEmployee(Employee newInfor) {
        if (this.employees.contains(newInfor)
                && searchEmployeeById(newInfor.getId()).getClass() == newInfor.getClass()) {
            removeEmployee(newInfor.getId());
            addEmployee(newInfor);
            return true;
        }
        return false;
    }

    // Trả về danh sách các nhân viên là nhân viên theo giờ và làm việc hơn 40 giờ một tuần
    public Set<Employee> getHourlyEmpsWorkMoreThan40(){
        return this.employees.stream()
                .filter(o -> (o instanceof HourlyEmployee) && ((HourlyEmployee) o).getHoursWorked() > 40)
                .collect(Collectors.toCollection(
                        () -> new HashSet<>()
                ));
    }

    // Trả về tổng lương hàng tuần của tất cả các nhân viên là người quản lý
    public double getWeeklyTotalSalaryOfManager(){
         return this.employees.stream()
                 .filter(o -> o instanceof Manager)
                 .collect(Collectors.summingDouble(
                         o -> o.weeklyPay()
                 ));
//                 .map(emp -> ((Manager) emp).weeklyPay())
//                 .reduce(0.0, Double::sum); // (a,b) -> a + b
    }

    // Cập nhật giờ làm việc của một nhân viên theo giờ khi biết mã số.
    // Ném lỗi nếu giờ làm việc mới nhỏ hơn 0, hoặc nếu mã nhân viên không tồn tại,
    // hoặc nhân viên không phải là nhân viên theo giờ
    public void updateHourlyWorked(String id, int newHour) {
        if (newHour < 0) {
            throw new IllegalArgumentException("Giờ làm việc không thể nhỏ hơn 0");
        }
        Employee employee = searchEmployeeById(id);
        if (employee == null) {
            throw new IllegalArgumentException("Nhân viên có số ID là " + id + " không tồn tại");
        }
        if (employee instanceof HourlyEmployee) {
            ((HourlyEmployee) employee).setHoursWorked(newHour);
        } else {
            throw new IllegalArgumentException("Nhân viên có số ID là " + id + " không là nhân viên theo giờ");
        }
    }

    // Trả về danh sách nhân viên trẻ làm quản lý (có tuổi < 30, tuổi = năm hiện tại – năm sinh)
    public Set<Employee> getYoungEmployeesAsManagers(){
        return this.employees.stream()
                .filter(o -> (o instanceof Manager)
                        && (LocalDate.now().getYear() - o.getDob().getYear()) < 30)
                .collect(Collectors.toCollection(
                        () -> new HashSet<>()
                ));
    }

    // Thống kê số nhân viên theo năm sinh
    public Map<Integer, Long> getNoOfEmployeesByYOB() {
        return this.employees.stream()
                .map(o -> o.getDob().getYear())
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldObj, newObj) -> newObj,
                        TreeMap::new
                ));
    }
    // Thống kê tổng tiền lương của từng loại nhân viên, kết quả sắp xếp theo tiền lương
    public  Map<String, Double> getTotalWeeklySalary(){
        return this.employees.stream()
                .collect(Collectors.groupingBy(o -> o.getClass(),
                        Collectors.summingDouble(Employee::weeklyPay)))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        o -> {
                            if (o.getKey() == HourlyEmployee.class) {
                                return "Hourly Employee";
                            } else if (o.getKey() == SalariedEmployee.class) {
                                return "Salaried Employee";
                            } else if (o.getKey() == Manager.class){
                                return "Manager";
                            } else {
                                return "";
                            }
                        },
                        o -> o.getValue(),
                        (oldObj, newObj) -> newObj,
                        TreeMap::new
                ));
    }
}
