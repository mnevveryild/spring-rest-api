package com.mnevveryldrm.services;

import com.mnevveryldrm.model.Employee;
import com.mnevveryldrm.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository; // enjeckte etmezsek null döner

    public List<Employee>getAllEmployeeList(){

        //1000 lerce satır kontrol yapılacak
       employeeRepository.getAllEmployeeList();
       return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id){
        return employeeRepository.getEmployeeById(id);

    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName){
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }



}
