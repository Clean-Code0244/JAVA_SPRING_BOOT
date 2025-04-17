package com.omertursun.cruddemo.dao;

import com.omertursun.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);

}
