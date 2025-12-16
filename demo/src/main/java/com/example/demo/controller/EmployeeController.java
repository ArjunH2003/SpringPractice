package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired 
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);


    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){

        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);

    }

      @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployeeById(id);

        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

     @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        employeeService.updateEmployee(id, employee);

        return new ResponseEntity<>("Employee updated successfully", HttpStatus.OK);
    }



    
}