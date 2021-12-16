package pro.sky.java.homeworks.course2.homework_7.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.homework_7.data.Employee;
import pro.sky.java.homeworks.course2.homework_7.exceptions.EmployeeAlreadyExistsException;
import pro.sky.java.homeworks.course2.homework_7.exceptions.EmployeeNotFoundException;
import pro.sky.java.homeworks.course2.homework_7.service.EmployeeService;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    Set employees = new HashSet<>();
    Set<Employee> employees = new HashSet<>();

    @Override
    public Employee addNew(String firstName, String lastName) {
        Employee newbie = new Employee(firstName, lastName);
        if (employees.contains(newbie)) {
            throw new EmployeeAlreadyExistsException();
        }
        employees.add(newbie);
        return newbie;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee removed = new Employee(firstName, lastName);
        if (!employees.contains(removed)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(removed);
        return removed;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee find = new Employee(firstName, lastName);
        if (employees.contains(find)) {
            return find;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Set<Employee> printEmployeeList() {
        return employees;
    }
}
