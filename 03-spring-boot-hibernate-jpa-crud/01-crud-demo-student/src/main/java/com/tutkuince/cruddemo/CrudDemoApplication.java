package com.tutkuince.cruddemo;

import com.tutkuince.cruddemo.dao.StudentDAO;
import com.tutkuince.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);

            createMultipleStudents(studentDAO);
        };
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        // create the student object
        System.out.println("Creating 3 Student Object . . .");
        Student tempStudent1 = new Student("John", "Doe", "john.doe@tutkuince.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary.public@tutkuince.com");
        Student tempStudent3 = new Student("Bonita", "Apple", "bonita.apple@tutkuince.com");

        // save the student objects
        System.out.println("Saving the students. . .");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new Student Object . . .");
        Student tempStudent = new Student("Tutku", "Ince", "ti@tutkuince.com");

        // save the student object
        System.out.println("Saving the Student . . .");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
