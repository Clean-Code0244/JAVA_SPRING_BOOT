package com.omertursun.cruddemo.dao;

import com.omertursun.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    //Just Read Only. So no need to add @Transactional
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("Select s from Student s",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("Select s from Student s where s.lastName = :theData",Student.class);
        theQuery.setParameter("theData", lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    // Again database operation so we need to add the @Transactional annotation.
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = findById(id);
        entityManager.remove(student);
    }
}
