package com.example.springjpahibernate.learnjpaandhibernate.course.jdbc;

import com.example.springjpahibernate.learnjpaandhibernate.course.Course;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan("com.example.springjpahibernate.learnjpaandhibernate.course")
public class CourseJdbcRepository {
    private final JdbcTemplate springjdbcTemplate;

    public CourseJdbcRepository(JdbcTemplate springjdbcTemplate) {
        this.springjdbcTemplate = springjdbcTemplate;
    }

    private static String INSERT_QUERY =
            """
                            INSERT INTO course (name, author)
                            values(?,?);
                            
                    """;

    private static String DELETE_QUERY =
            """
                    DELETE FROM course WHERE id=?;
                        
                                
                    """;

    private static String SELECT_QUERY =
            """
                    SELECT * FROM course WHERE id=?;
                        
                                
                    """;

    public void insert(Course course) {
        springjdbcTemplate.update(INSERT_QUERY, course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springjdbcTemplate.update(DELETE_QUERY, 1);
    }

    public Course findById(long id) {
//        ResultSet -> Bean = Row Mapper
//        id
        return springjdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);

    }


}

