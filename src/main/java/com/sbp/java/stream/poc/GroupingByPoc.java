package com.sbp.java.stream.poc;

import com.sbp.java.stream.models.Employee;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class GroupingByPoc {

    public void groupBy() {

        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee("1", "1", 10000000);
        employees.add(emp1);

        Employee emp2 = new Employee("1", "2", 11000000);
        employees.add(emp2);

        Employee emp3 = new Employee("1", "3", 12000000);
        employees.add(emp3);

        Employee emp4 = new Employee("2", "4", 20000000);
        employees.add(emp4);

        Employee emp5 = new Employee("2", "5", 22000000);
        employees.add(emp5);

        Employee emp6 = new Employee("2", "6", 25000000);
        employees.add(emp6);

        Employee emp7 = new Employee("3", "7", 30000000);
        employees.add(emp7);

        Employee emp8 = new Employee("3", "8", 40000000);
        employees.add(emp8);

        Employee emp9 = new Employee("3", "9", 50000000);
        employees.add(emp9);

        Employee emp10 = new Employee("3", "10", 55000000);
        employees.add(emp10);

        //Print 2nd highest salary employee from each department

        log.info("Find the 2nd highest salary employee from each department: ");

        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartmentId,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                        .skip(1).findFirst().orElseThrow())
                ))
                .values()
                .stream()
                .forEach(e->System.out.println(e));

        log.info("Alternate approach: Find the 2nd highest salary employee from each department");
        Map<String, List<Employee>> empMap = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartmentId,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list->list.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                        .skip(1)
                                        .toList()
                        )));

        log.info("=============================");
        log.info("empMap: " + empMap);
    }
}
