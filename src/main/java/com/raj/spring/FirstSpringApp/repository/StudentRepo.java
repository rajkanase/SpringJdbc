package com.raj.spring.FirstSpringApp.repository;

import com.raj.spring.FirstSpringApp.model.Student;

import java.util.List;

public interface StudentRepo {
    List<Student> getData();
    String getImg();
    List<Student> getDbData();
}
