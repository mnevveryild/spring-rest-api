package com.mnevveryldrm.repository;


import com.mnevveryldrm.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList() {


        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }


    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }
        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {
                if (employee.getFirstname().equalsIgnoreCase(firstName) && employee.getLastname().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }


            if (lastName != null && firstName == null) {
                if (employee.getLastname().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }
            if (firstName != null && lastName == null) {
                if (employee.getFirstname().equalsIgnoreCase(firstName)) {
                    employeeWithParams.add(employee);
                }
            }



        }


        return employeeWithParams;
    }
}