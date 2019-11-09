package com.example.pagination2.controller;

import com.example.pagination2.entity.Employee;
import com.example.pagination2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employees")
    public String getEmployees(@PageableDefault(size = 5) Pageable pageable,
                               Model model) {
        Page<Employee> page = employeeRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "employee-page";
    }
    @GetMapping("/fake")
    public String fake(Employee employee){
        employee.setName("name-1");
        employee.setDept("dept-1");
        employee.setSalary(1000);
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
}
