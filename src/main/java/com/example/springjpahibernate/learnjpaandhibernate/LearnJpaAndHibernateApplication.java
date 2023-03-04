package com.example.springjpahibernate.learnjpaandhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LearnJpaAndHibernateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(LearnJpaAndHibernateApplication.class, args);
	}

}
