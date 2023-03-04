package com.example.springjpahibernate.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    private final JdbcTemplate springjdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate springjdbcTemplate) {
        this.springjdbcTemplate = springjdbcTemplate;
    }


    private static String INSERT_QUERY=
            """
                    INSERT INTO course (id, name, author)
                    values(1,'Learn AWS','in28minutes');
                    
                    """;



    public void insert(){
        springjdbcTemplate.update(INSERT_QUERY);
    }

}
