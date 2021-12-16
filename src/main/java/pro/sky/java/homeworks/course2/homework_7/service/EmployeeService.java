package pro.sky.java.homeworks.course2.homework_7.service;

import pro.sky.java.homeworks.course2.homework_7.data.Employee;

import java.util.Set;

public interface EmployeeService {
    Employee addNew(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Set<Employee> printEmployeeList();

}
