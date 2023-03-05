package com.example.springjpahibernate.learnjpaandhibernate.course;

import com.example.springjpahibernate.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.example.springjpahibernate.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.example.springjpahibernate.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJPAandJdbcCommandLineRunner implements CommandLineRunner {

    private CourseSpringDataJpaRepository springDataJpaRepository;
    private CourseJdbcRepository repository;
    private CourseJpaRepository jpaRepository;

    public CourseJPAandJdbcCommandLineRunner(CourseSpringDataJpaRepository springDataJpaRepository, CourseJdbcRepository repository, CourseJpaRepository jpaRepository) {
        this.springDataJpaRepository = springDataJpaRepository;
        this.repository = repository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        springDataJpaRepository.save(new Course("Learn AWS Now!", "in28minutes"));
        springDataJpaRepository.save(new Course("Learn Azure Now!", "in28minutes"));
        springDataJpaRepository.save(new Course("Learn DevOps Now!", "in28minutes"));
        springDataJpaRepository.deleteById(1l);
        springDataJpaRepository.delete(new Course("Learn Azure Now!", "in28minutes"));

        Course course2;

        System.out.println(springDataJpaRepository.findById(2L));
        System.out.println(springDataJpaRepository.findById(3L));

        System.out.println(springDataJpaRepository.findAll());
        System.out.println(springDataJpaRepository.count());
        System.out.println(springDataJpaRepository.findByAuthor("in28minutes"));
        System.out.println(springDataJpaRepository.findByAuthor(""));
        System.out.println(springDataJpaRepository.findByName("Learn Azure Now!"));

//        Course course2 = springDataJpaRepository.findById(2L).orElse(null);
//        System.out.println(course2);
    }


    // for entity manager code - comment the jdbc template code to implement this line of code


//    @Override
//    public void run(String... args) throws Exception {
//        jpaRepository.insert(new Course("Learn AWS Now!", "in28minutes"));
//        jpaRepository.insert(new Course("Learn Azure Now!", "in28minutes"));
//        jpaRepository.insert(new Course("Learn DevOps Now!", "in28minutes"));
//        jpaRepository.deleteById(1);
//
//        System.out.println(jpaRepository.findById(2));
//        System.out.println(jpaRepository.findById(3));
//    } // end of entity manager code


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
