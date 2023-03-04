package com.example.springjpahibernate.learnjpaandhibernate.course;

import com.example.springjpahibernate.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.springjpahibernate.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPAandJdbcCommandLineRunner implements CommandLineRunner {

    private CourseJdbcRepository repository;
    private CourseJpaRepository jpaRepository;

    @Autowired
    public CourseJPAandJdbcCommandLineRunner(CourseJdbcRepository repository, CourseJpaRepository jpaRepository) {
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    // for entity manager code - comment the jdbc template code to implement this line of code
    @Override
    public void run(String... args) throws Exception {
        jpaRepository.insert(new Course("Learn AWS Now!", "in28minutes"));
        jpaRepository.insert(new Course("Learn Azure Now!", "in28minutes"));
        jpaRepository.insert(new Course("Learn DevOps Now!", "in28minutes"));
        jpaRepository.deleteById(1);

        System.out.println(jpaRepository.findById(2));
        System.out.println(jpaRepository.findById(3));
    } // end of entity manager code

//     for jdbc template code - comment the entity manager code to implement this line of code
//    @Override
//    public void run(String... args) throws Exception {
//        repository.insert(new Course("Learn AWS Now!", "in28minutes"));
//        repository.insert(new Course("Learn Azure Now!", "in28minutes"));
//        repository.insert(new Course("Learn DevOps Now!", "in28minutes"));
//        repository.deleteById(1);
//        System.out.println(repository.findById(2));
//        System.out.println(repository.findById(3));
//    } // end of jdbc template code


    //only perform insertNew() when the Bean "insertNew" is called via getBean method of the context
//    @Bean("insertNew")
//    @Lazy
//    public void insertNew(){
//        repository.insert(new Course(2,"Hello","Robert"));
//    }
}
