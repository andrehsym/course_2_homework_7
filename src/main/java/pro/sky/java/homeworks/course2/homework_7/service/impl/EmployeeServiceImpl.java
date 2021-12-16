package pro.sky.java.homeworks.course2.homework_7.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.homeworks.course2.homework_7.data.Employee;
import pro.sky.java.homeworks.course2.homework_7.exceptions.EmployeeAlreadyExistsException;
import pro.sky.java.homeworks.course2.homework_7.exceptions.EmployeeNotFoundException;
import pro.sky.java.homeworks.course2.homework_7.service.EmployeeService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, String> employees = new HashMap<>();

    @Override
    public Employee addNew(String fullName, String phoneNumber) {
        Employee newbie = new Employee(fullName, phoneNumber);
        if (employees.containsKey(fullName) || employees.containsValue(phoneNumber)) {
            throw new EmployeeAlreadyExistsException();
        }
        employees.put(fullName, phoneNumber);
        return newbie;
    }

    @Override
    public Employee remove(String fullName, String phoneNumber) {
        Employee removed = new Employee(fullName, phoneNumber);
        if (employees.containsKey(fullName) && employees.containsValue(phoneNumber)) {
            employees.remove(fullName);
            return removed;
        }
        throw new EmployeeNotFoundException();

//        if (!employees.containsKey(fullName)) {
//            throw new EmployeeNotFoundException();
//        }
//        employees.remove(fullName);
//        return removed;
    }

    @Override
    public String removeAnEmployeeByKey(String fullName) {
        if (employees.containsKey(fullName)) {
            employees.remove(fullName);
            return fullName;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String fullName, String phoneNumber) {
        Employee find = new Employee(fullName, phoneNumber);
        if (employees.containsKey(fullName) && employees.containsValue(phoneNumber)) {
            return find;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String findAnEmployeeByKey(String fullName) {
        if (employees.containsKey(fullName)) {
            return fullName;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Map<String, String> printEmployeeList() {
        for (Map.Entry<String, String> contact: employees.entrySet()) {
            System.out.println("Сотрудник: " + contact.getKey()+ "; телефон: " + contact.getValue());
        }
        return employees;
    }
}
