package com.example.springjpahibernate.learnjpaandhibernate.course.jpa;

import com.example.springjpahibernate.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
//@Repository indicates that a class talks to a database and provides mechanism for storage, retrieval, search, update and delete operation for objects
@Transactional
//always used whenever you execute queries with JPA
public class CourseJpaRepository {
    @PersistenceContext
    private final EntityManager entityManager; //We need EntityManager to manage our database

    public CourseJpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Course course) {
        entityManager.merge(course);
    }


    //find an Object of type indicated and return it using find() method of an instance of EntityManager
    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);


    }


}
