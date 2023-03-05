package com.example.springjpahibernate.learnjpaandhibernate.course;

import jakarta.persistence.*;


//for jdbc command line runner - JdbcTemplate - remove the JPA annotations - @Entity
@Entity //comment this annotation if you want to use jdbc template
//if different name and table @Entity(name ="CourseDetails")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;

//    for jdbc command line runner - JdbcTemplate - remove the JPA annotations

//    private long id;
//    private String name;
//    private String author;

    public Course() {

    }

    public Course(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
