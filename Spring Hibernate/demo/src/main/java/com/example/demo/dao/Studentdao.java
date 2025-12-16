package com.example.demo.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.example.demo.bean.StudentBean;
@Repository
public class Studentdao {

    @Autowired
    private SessionFactory sessionFactory;

    public int addStudent(StudentBean sb){

        Session s=sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        if(sb!=null){
            s.persist(sb);
            t.commit();
            System.out.println("Added succesfully!");
            return 1;
        }

        return 0;
    }

    public int updateStudent(StudentBean sb){

        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        if(sb!=null){
            s.merge(sb);
            t.commit();
            System.out.println("Success!");
            return 1;
        }

        return 0;
    }

    public int deleteStudent(int id){

        Session s = sessionFactory.openSession();
        Transaction t = s.beginTransaction();
        StudentBean sb = new StudentBean();
        sb=s.get(StudentBean.class, id);
        if(id!=0){
            s.remove(sb);
            t.commit();
            System.out.println("Deleted Student with id" + id);
            return 1;
        }

        return 0;
    }

    
}