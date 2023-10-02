package test;

import main.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeListTest {
    private EmployeeList list;
    private Employee employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9;

    @BeforeEach
    void setUp() {
        list = new EmployeeList();
        employee1 = new HourlyEmployee("H002","Morgan, Harry", LocalDate.of(1995,2,12), 50,10.0);
        employee2 = new HourlyEmployee("H001","Walker, Peter", LocalDate.of(1996,7,10), 40,10.0);
        employee3 = new HourlyEmployee("H003","Smith, John", LocalDate.of(1999,5,3), 39,10.0);
        employee4 = new SalariedEmployee("S005","Sirius, Joseph", LocalDate.of(1992,12,12), 50200.0);
        employee5 = new SalariedEmployee("S004","Brown, Sofia", LocalDate.of(1996,8,22), 60000.0);
        employee6 = new SalariedEmployee("S009","Cassandra, Rudy", LocalDate.of(1997,1,29), 40000.0);
        employee7 = new Manager("S006","Oak, Morphia", LocalDate.of(1994,12,11), 52000.0, 50.0);
        employee8 = new Manager("S008","Lemantine, Katherin", LocalDate.of(1995,9,10), 52000.0, 35.0);
        employee9 = new Manager("S007","Parker, Martin", LocalDate.of(1998,7,6), 52000.0, 45.0);
        Employee[] emps = {employee1, employee2, employee3, employee4, employee5, employee6, employee7, employee8, employee9};
        Set<Employee> employees = new HashSet<>();
        employees.addAll(Arrays.stream(emps).collect(Collectors.toList()));
        EmployeeList employeeList = new EmployeeList();
        list.addAll(employees);
    }

    @AfterEach
    void tearDown() {
        list.getEmployees().forEach(obj -> obj = null);
        list = null;
    }

    @ParameterizedTest
    @CsvSource({
            "1,H021,"
            , "2,S004,Nhân viên có số ID là S004 đã tồn tại"
            , "3,H002,Nhân viên có số ID là H002 đã tồn tại"
    })
    void testAddEmployee(int type, String id, String expected){
        // 1-Hourly employee; 2-Salaried employee; 3-Manager
        Employee employee;
        switch (type) {
            case 1: employee = new HourlyEmployee(id,"",LocalDate.now(),0,0.0); break;
            case 2: employee = new SalariedEmployee(id, "", LocalDate.now(), 0.0); break;
            default: employee = new Manager(id, "", LocalDate.now(), 0.0, 0.0); break;
        }
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.addEmployee(employee);
            throw new IllegalArgumentException();
        });
        assertEquals(expected, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "S004,S004"
            , "S001,null"
    })
    void testSearchEmployeeById(String id, String expected) {
        Employee employee = list.searchEmployeeById(id);
        String result = (employee == null) ? "null" : employee.getId();
        assertEquals(expected, result);
    }
    @Test
    void testGetWeeklyTotalSalaryOfManager(){
        double expected = 3130.0;
        double actual =  list.getWeeklyTotalSalaryOfManager();
        assertEquals(expected, actual, 0.000005);
    }

    @ParameterizedTest
    @CsvSource({
            "H001,100,"
            , "H001,0,"
            , "H001,-1,Giờ làm việc không thể nhỏ hơn 0"
            , "H010,10,Nhân viên có số ID là H010 không tồn tại"
            , "S005,60,Nhân viên có số ID là S005 không là nhân viên theo giờ"
    })
    void testUpdateHourlyWorked(String id, int newHour, String expected){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            list.updateHourlyWorked(id,newHour);
            throw new IllegalArgumentException();
        });
        assertEquals(expected, exception.getMessage());
    }
}