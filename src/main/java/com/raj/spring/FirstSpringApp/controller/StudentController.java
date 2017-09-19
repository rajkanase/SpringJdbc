package com.raj.spring.FirstSpringApp.controller;

import com.raj.spring.FirstSpringApp.model.Order;
import com.raj.spring.FirstSpringApp.model.Student;
import com.raj.spring.FirstSpringApp.repository.StudentRepo;
import com.raj.spring.FirstSpringApp.studentimpl.StudentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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


    @GetMapping(value = "/deletedata")
    String deldata(@RequestParam Integer id){
        studentImpl.deleteData(id);
        return "Data deleted successfully..!";
    }

    @GetMapping(value = "/updatedata")
    String updata(@RequestParam Integer id,
                  @RequestParam String name){
        studentImpl.updateData(id,name);
        return "Data updated successfully..!";
    }


    @GetMapping(value = "/getjoindata")
    List<Map<String,Object>> joinData(){
        List<Map<String,Object>> li=studentImpl.getJoinData();
//        System.out.println(li);
        return li;
    }


    @PostMapping(value = "/savedata")
    String getImageAndData(@RequestParam Integer id,
                           @RequestParam String name,
                           @RequestParam String city,
                           @RequestParam MultipartFile file){

        String imagename=file.getOriginalFilename();
        File f=new File("/home/raj/Desktop/Mess/"+imagename);
        String st=f.getAbsolutePath();
        System.out.println(st);

        Student s=new Student();
        s.setId(id);
        s.setName(name);
        s.setCity(city);
        s.setImgpath(imagename);


        try {
            file.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentImpl.saveData(s);

        return "Data Saved Successfully..";

    }

    @PostMapping(value = "/insertjoindata")
    String insertJoin(@RequestBody Order order){

//        Order ord=new Order();
//        ord.setId(order.getId());
//        ord.setOrdernumber(order.getOrdernumber());
//        ord.setCustid(order.getCustid());
//        ord.setTotalamt(order.getTotalamt());

        studentImpl.insertJoinData(order);

        return "Data Inserted into Join tables";
    }




}