package com.raj.spring.FirstSpringApp.controller;

import com.raj.spring.FirstSpringApp.model.Student;
import com.raj.spring.FirstSpringApp.repository.StudentRepo;
import com.raj.spring.FirstSpringApp.studentimpl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentImpl studentImpl;

//    StudentController(StudentImpl studentImpl){
//        this.studentImpl=studentImpl;
//    }

    @Autowired
    public void setStudentImpl(StudentImpl studentImpl){
        this.studentImpl=studentImpl;
    }

    @GetMapping(value="/getdata")
    String getImg(){
        String path=studentImpl.getImg();
        System.out.println("path");
        return path;
    }

    @GetMapping(value = "/getStudentData")
    List<Student> data(){

        List li=studentImpl.getData();
        System.out.println(li);
        return li;

    }

    @GetMapping(value = "/getdbdata")
    List<Student> dbData(){
        List<Student> li=studentImpl.getDbData();
        System.out.println(li);
        return li;
    }



}