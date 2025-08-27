package com.mnevveryldrm.repository;


import com.mnevveryldrm.model.Employee;
import com.mnevveryldrm.model.updateEmployeeRequest;
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

    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id){
        //delete from Employee WHERE id = :id
        Employee deleteEmployee =null;
        for (Employee employee :employeeList) {
            if (id.equals(employee.getId())){
                deleteEmployee = employee;
                break;
            }
        }
        if(deleteEmployee == null) {
            return false;
        }
        employeeList.remove(deleteEmployee);
        return true;
    }

    private Employee findEmployeeById(String id) {
        Employee findEmployee = null;

        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                findEmployee = employee;
                break;

            }
        }

        return findEmployee;
    }


    public  Employee updateEmployee(String id, updateEmployeeRequest request){
        Employee findEmployee = findEmployeeById(id);
        if (findEmployee != null){

            deleteEmployee(id);

            Employee updateEmployee = new Employee();
            updateEmployee.setId(id);
            updateEmployee.setFirstname(request.getFirstname());
            updateEmployee.setLastname(request.getLastname());

            employeeList.add(updateEmployee);

            return updateEmployee;
        }

        return findEmployee;
    }







}