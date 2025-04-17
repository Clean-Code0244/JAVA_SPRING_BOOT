package com.omertursun.cruddemo.dao;

import com.omertursun.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.entityManager = em;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
    @Override
    //Just Read Only. So no need to add @Transactional
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

}
