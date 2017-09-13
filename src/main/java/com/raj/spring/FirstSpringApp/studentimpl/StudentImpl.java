package com.raj.spring.FirstSpringApp.studentimpl;

import com.raj.spring.FirstSpringApp.model.Student;
import com.raj.spring.FirstSpringApp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentImpl implements StudentRepo{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Value("${image.path}")
    String path;

    @Override
    public List<Student> getData() {

        List<Student> list=new ArrayList<>();
        Student s=new Student();
        s.setId(1);
        s.setName("Rajkumar");
        s.setCity("Pune");

        Student s1=new Student();
        s1.setId(2);
        s1.setName("Raj");
        s1.setCity("Mumbai");

        list.add(s);
        list.add(s1);

        return list;
    }

    @Override
    public String getImg() {
        return path;
    }

    @Override
    public List<Student> getDbData() {
        String sql="select * from mytable";

        List<Student> li=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return li;
    }


}
