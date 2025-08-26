package com.mnevveryldrm.config;

import com.mnevveryldrm.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class AppConfig {


    @Bean
    public List<Employee> employeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","münevver","yıldırım"));
        employeeList.add(new Employee("2","ipek","savas"));
        employeeList.add(new Employee("3","ezgi","akcay"));
        return employeeList;
    }


}
