package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.bean.StudentBean;
import com.example.demo.dao.Studentdao;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    private Studentdao sdao;
    @Transactional
    public int addStudent(StudentBean sb){
        return sdao.addStudent(sb);
    }

    @Transactional
    public int updateStudent(StudentBean sb){
        return sdao.updateStudent(sb);
    }

    @Transactional
    public int deleteStudent(int id){
        return sdao.deleteStudent(id);
    }

    
}
