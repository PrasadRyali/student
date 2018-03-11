package com.prs.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prs.student.controller.StudentController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	private static final Logger log=LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
     SpringApplication.run(App.class, args);
     log.info("Spring Boot Application Started S T U D E N T");
    }
}
