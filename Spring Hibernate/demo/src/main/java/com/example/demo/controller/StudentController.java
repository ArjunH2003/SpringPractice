package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.StudentBean;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService serv;

     @PostMapping("/add") 
    public int meth1(@RequestBody StudentBean sb){
        return serv.addStudent(sb);
    }

    @PutMapping("/update")
    public int meth2(@RequestBody StudentBean sb){
        return serv.updateStudent(sb);
    }

    @DeleteMapping("/delete")
    public int meth3(int id){
        return serv.deleteStudent(id);
    }
    
}
