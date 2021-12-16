package pro.sky.java.homeworks.course2.homework_7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.homeworks.course2.homework_7.data.Employee;
import pro.sky.java.homeworks.course2.homework_7.service.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("fullname") String fullName, @RequestParam ("phonenumber") String phoneNumber) {
        Employee newbie = employeeService.addNew(fullName, phoneNumber);
        return "Сотрудник " + newbie.getFullName() + " успешно создан";
    }

    @GetMapping("/removebykey")
    public String remove(@RequestParam("fullname") String fullName) {
        return "Сотрудник " + employeeService.removeAnEmployeeByKey(fullName) + " удален";
    }

    @GetMapping("/removebykeywithvalue")
    public String remove(@RequestParam("fullname") String fullName, @RequestParam ("phonenumber") String phoneNumber) {
        Employee deleted = employeeService.remove(fullName, phoneNumber);
        return "Удален сотрудник: " + deleted.getFullName() + "; телефон: " + deleted.getPhoneNumber();
    }

    @GetMapping("/findbykey")
    public String find(@RequestParam("fullname") String fullName) {
        return "Сотрудник " + employeeService.findAnEmployeeByKey(fullName) + " найден";
    }

    @GetMapping("/findbykeywithvalue")
    public String find(@RequestParam("fullname") String fullName, @RequestParam ("phonenumber") String phoneNumber) {
        Employee find = new Employee(fullName, phoneNumber);
//        return String.valueOf(employeeService.find(fullName, phoneNumber));
//        return "Найден сотрудник: " + find.getFullName();
        return "Найден сотрудник: " + find.getFullName() + "; телефон: " + find.getPhoneNumber();
    }



    @GetMapping("/printlist")
    public Map<String, String> print() {
        return employeeService.printEmployeeList();
    }
}
