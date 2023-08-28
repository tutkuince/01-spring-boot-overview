package com.tutkuince.springboot.advancedjpa;

import com.tutkuince.springboot.advancedjpa.entity.Course;
import com.tutkuince.springboot.advancedjpa.entity.Instructor;
import com.tutkuince.springboot.advancedjpa.entity.InstructorDetail;
import com.tutkuince.springboot.advancedjpa.service.InstructorDetailService;
import com.tutkuince.springboot.advancedjpa.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdvancedJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorService instructorService, InstructorDetailService instructorDetailService) {
        return runner -> {
            // createInstructor(instructorService);
            // findInstructor(instructorService);
            // deleteInstructorById(instructorService);
            // findInstructorDetail(instructorDetailService);
            // deleteInstructorDetailById(instructorDetailService);
            // create Instructor with courses
            // createInstructorWithCourses(instructorService);
            findInstructorWithCourses(instructorService);
        };
    }

    private void findInstructorWithCourses(InstructorService instructorService) {
        int id = 1;
        System.out.println("Finding the instructor id: " + id);

        Instructor instructor = instructorService.findById(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("The Associated courses: " + instructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(InstructorService instructorService) {
        // create the instructor
        Instructor instructor = new Instructor("Tutku", "Ince", "tutku@tutkuince.com");

        // create the instructor detail
        InstructorDetail instructorDetail = new InstructorDetail("OCPJD TV", "Playing Guitar");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // create some Courses
        List<Course> courseList = new ArrayList<>();
        Course course1 = new Course("Spring Boot");
        Course course2 = new Course("Hibernate");
        Course course3 = new Course("Aspect Oriented Programming");

        // add courses to instructor
        instructor.addCourse(course1);
        instructor.addCourse(course2);
        instructor.addCourse(course3);

        // Save the instructor
        // Note: This will also save the courses because of CascadeType.PERSIST
        System.out.println("Saving instructor: " + instructor);
        System.out.println("The courses: " + instructor.getCourses());
        instructorService.save(instructor);
        System.out.println("Done!");
    }

    private void deleteInstructorDetailById(InstructorDetailService instructorDetailService) {
        int id = 1;
        System.out.println("Deleting InstructorDetail id: " + id);
        instructorDetailService.deleteById(id);
        System.out.println("Done!");
    }

    private void findInstructorDetail(InstructorDetailService instructorDetailService) {
        int id = 1;
        InstructorDetail instructorDetail = instructorDetailService.findById(1);
        System.out.println("InstructorDetail: " + instructorDetail);
        System.out.println("Associated Instructor: " + instructorDetail.getInstructor());
        System.out.println("Done!");

    }

    private void deleteInstructorById(InstructorService instructorService) {
        int id = 1;
        System.out.println("Deleting instructor id: " + instructorService);

        instructorService.deleteById(id);

        System.out.println("Done!");
    }

    private void findInstructor(InstructorService instructorService) {
        int id = 1;
        System.out.println("Finding instructor id: " + id);

        Instructor instructor = instructorService.findById(id);

        System.out.println("Instructor: " + instructor);
        System.out.println("The Associate InstructorDetail: " + instructor.getInstructorDetail());
    }

    private void createInstructor(InstructorService instructorService) {
        // create the instructor
        Instructor instructor = new Instructor("Tutku", "Ince", "tutku@tutkuince.com");

        // create the instructor detail
        InstructorDetail instructorDetail = new InstructorDetail("OCPJD TV", "Playing Guitar");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        // save the instructor
        System.out.println("Saving instructor: " + instructor);
        instructorService.save(instructor);
        System.out.println("Saved instructor: " + instructor);
    }

}
