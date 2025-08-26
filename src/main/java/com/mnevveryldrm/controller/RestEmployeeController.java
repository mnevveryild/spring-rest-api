package com.mnevveryldrm.controller;

import com.mnevveryldrm.model.Employee;
import com.mnevveryldrm.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee") //ortak kök adres ekledim
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployeeList() {
        employeeService.getAllEmployeeList();
        return employeeService.getAllEmployeeList();

    }
    @GetMapping(path = "/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id", required = true)String id){
        return employeeService.getEmployeeById(id);

    }
    @GetMapping(path = "with-params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName",required = false)String firstName,
                                                @RequestParam(name = "lastName",required = false)String lastName){

        return employeeService.getEmployeeWithParams(firstName,lastName);

    }


}
