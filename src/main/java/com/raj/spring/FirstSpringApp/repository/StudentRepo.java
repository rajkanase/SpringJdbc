package com.raj.spring.FirstSpringApp.repository;

import com.raj.spring.FirstSpringApp.model.Order;
import com.raj.spring.FirstSpringApp.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentRepo {
    List<Student> getData();
    String getImg();
    List<Student> getDbData();
    void saveData(Student s);
    void deleteData(Integer id);
    void updateData(Integer id,String name);
    List<Map<String,Object>> getJoinData();
    void insertJoinData(Order order);

}
