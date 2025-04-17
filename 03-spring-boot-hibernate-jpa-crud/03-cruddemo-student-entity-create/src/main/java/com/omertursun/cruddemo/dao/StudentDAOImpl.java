package com.omertursun.cruddemo.dao;

import com.omertursun.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager em) {
        this.entityManager = em;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

}
