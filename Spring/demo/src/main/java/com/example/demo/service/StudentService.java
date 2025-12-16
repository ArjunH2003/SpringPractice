package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.bean.StudetBean;
import com.example.demo.dao.StudentDao;

@Service
public class StudentService {

    @Autowired
    private StudentDao sdao;

    public ResponseEntity<StudetBean> addStudent(StudetBean sb){

        if(sb!=null){
            sdao.save(sb);
            return ResponseEntity.ok().body(sb);
        }

        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<StudetBean> getStudent(int id){

        StudetBean sb = null;
        Optional<StudetBean> op = sdao.findById(id);
        if(op.isPresent()){

            sb = op.get();
            return ResponseEntity.ok().body(sb);
           
        }
        return ResponseEntity.noContent().build();


    }

    public List<StudetBean> getAllStudents(){

        return sdao.findAll();
    }

    public int updateStudents(StudetBean sb){

        Optional<StudetBean> op = sdao.findById(sb.getSid());
        if(op.isEmpty()){
          return 0;
        }else{
            StudetBean s = op.get();
            sdao.save(s);
            return 1;
        }
    }

//     public int updateStudent(StudetBean sb) {
	
// 	if(sb!=null) {
// 		Optional<StudetBean> opt =sdao.findById(sb.getSid());
// 		if(opt.isPresent()) {
			
// 			sdao.save(opt.get());
// 			return 1;
			
// 		}
// 	}
// 	return 0;
// }

    public int deleteStudent(int id){

       if(id!=0){
        sdao.deleteById(id);
        return 1;
       }

       return 0;

        }
        
    }
