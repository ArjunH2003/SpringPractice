package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.exception.InvalidSalaryException;


@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        if(employee.getSalary()<10000){ 

            throw new InvalidSalaryException("Salary should be greater than 10000");

        }
        employees.add(employee);
    }

    public List<Employee> getAllEmployees(){
        return employees;
    }

        public void deleteEmployeeById(Long id) {

        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }

        // If not found
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }

    public void updateEmployee(Long id, Employee updatedEmployee) {

        for (Employee emp : employees) {

            if (emp.getId().equals(id)) {

                // salary validation
                if (updatedEmployee.getSalary() < 10000) {
                    throw new InvalidSalaryException("Salary must be greater than 10000");
                }

                emp.setName(updatedEmployee.getName());
                emp.setDesignation(updatedEmployee.getDesignation());
                emp.setSalary(updatedEmployee.getSalary());

                return;
            }
        }

        // employee not found
        throw new EmployeeNotFoundException("Employee not found with id: " + id);
    }

       
    }