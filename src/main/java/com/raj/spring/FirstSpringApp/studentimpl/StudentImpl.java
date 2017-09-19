package com.raj.spring.FirstSpringApp.studentimpl;

import com.raj.spring.FirstSpringApp.model.Order;
import com.raj.spring.FirstSpringApp.model.Student;
import com.raj.spring.FirstSpringApp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public void saveData(Student s) {
        String sql="insert into mytable values(?,?,?,?)";

        jdbcTemplate.update(sql,new Object[]{
                s.getId(),s.getName(),s.getCity(),s.getImgpath()
        });
    }

    @Override
    public void deleteData(Integer id) {
        String sql="delete from mytable where id=?";

        jdbcTemplate.update(sql,new Object[]{id});
    }

    @Override
    public void updateData(Integer id,String name) {
        String sql="update mytable set name=? where id=?";

        jdbcTemplate.update(sql,new Object[]{name,id});
    }

    @Override
    public List<Map<String, Object>> getJoinData() {
        String sql="select ot.ordernumber,ot.totalamount,ct.firstname,ct.lastname,ct.city from order_table ot join customer_table ct on ot.customerid=ct.id;";
        List<Map<String,Object>> li=jdbcTemplate.queryForList(sql);
        return li;
    }

    @Override
    public void insertJoinData(Order ord) {
        ord.
    }


}
