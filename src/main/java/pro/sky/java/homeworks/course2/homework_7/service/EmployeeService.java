package pro.sky.java.homeworks.course2.homework_7.service;

import pro.sky.java.homeworks.course2.homework_7.data.Employee;

import java.util.Map;
import java.util.Set;

public interface EmployeeService {

    Employee addNew(String fullName, String phoneNumber);

    Employee remove(String fullName, String phoneNumber);

    String removeAnEmployeeByKey(String fullName);

    Employee find(String fullName, String phoneNumber);

//    String findAnEmployeeByKey(String fullName, String phoneNumber);

    String findAnEmployeeByKey(String fullName);

    Map<String, String> printEmployeeList();

//    Employee addNew(String firstName, String lastName);
//
//    Employee remove(String firstName, String lastName);
//
//    Employee find(String firstName, String lastName);
//
//    Set<Employee> printEmployeeList();

}
