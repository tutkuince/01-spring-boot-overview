package com.tutkuince.cruddemo;

import com.tutkuince.cruddemo.dao.StudentDAO;
import com.tutkuince.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);

            // createMultipleStudents(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting Student with Id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Master"
        System.out.println("Updating student. . .");
        myStudent.setFirstName("Master Tutku");

        // update the student
        studentDAO.update(myStudent);

        // display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> studentList = studentDAO.findByLastName("Ince");

        // display list of students
        for (Student tempStudent :
                studentList) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> studentList = studentDAO.findAll();

        // display list of students
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object . . .");
        Student tempStudent = new Student("Memo", "Can", "memo.can@tutkuince.com");

        // save the student
        System.out.println("Saving the student . . .");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display the student
        System.out.println("Found the student: " + tempStudent);
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
