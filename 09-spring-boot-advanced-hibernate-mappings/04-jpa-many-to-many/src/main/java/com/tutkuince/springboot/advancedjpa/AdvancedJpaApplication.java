package com.tutkuince.springboot.advancedjpa;

import com.tutkuince.springboot.advancedjpa.entity.*;
import com.tutkuince.springboot.advancedjpa.service.CourseService;
import com.tutkuince.springboot.advancedjpa.service.InstructorDetailService;
import com.tutkuince.springboot.advancedjpa.service.InstructorService;
import com.tutkuince.springboot.advancedjpa.service.StudentService;
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
    public CommandLineRunner commandLineRunner(CourseService courseService, StudentService studentService) {
        return runner -> {
            // createCourseAndStudent(courseService);
            // findCourseAndStudents(courseService);
            // findStudentAndCourses(studentService);
            // addMoreCoursesForStudent(studentService);
            deleteCourse(courseService);
        };
    }

    private void deleteCourse(CourseService courseService) {
        int id = 7;
        System.out.println("Deleting Course Id: " + id);

        courseService.deleteById(id);
        System.out.println("Done!");
    }

    private void addMoreCoursesForStudent(StudentService studentService) {
        int id = 1;
        Student student = studentService.findStudentAndCoursesByStudentId(id);

        Course c1 = new Course("Mastering German Language");
        Course c2 = new Course("Mastering at Cooking");

        student.addCourse(c1);
        student.addCourse(c2);

        System.out.println("Saving Student: " + student);
        System.out.println("Associated Courses: " + student.getCourses());

        studentService.save(student);
        System.out.println("Done!");
    }

    private void findStudentAndCourses(StudentService studentService) {
        int id = 1;
        Student student = studentService.findStudentAndCoursesByStudentId(id);

        System.out.println("Loaded Student: " + student);
        System.out.println("Associated Courses: " + student.getCourses());
        System.out.println("Done");
    }

    private void findCourseAndStudents(CourseService courseService) {
        int id = 5;
        Course course = courseService.findCourseAndStudentsByCourseId(id);
        System.out.println("Loaded Course: " + course);
        System.out.println("Associated Students: " + course.getStudents());
        System.out.println("Done");
    }

    private void createCourseAndStudent(CourseService courseService) {
        // create a course
        Course course = new Course("Mastering Spring Data JPA");
        // create the students
        Student student1 = new Student("Cigdem", "Ince", "cido@ince.com");
        Student student2 = new Student("Gizem", "Sen", "gizo@sen.com");

        // add students to the course
        course.addStudent(student1);
        course.addStudent(student2);

        // save the course and associated students
        System.out.println("Saving the Course: " + course);
        System.out.println("Associated Students: " + course.getStudents());
        courseService.save(course);
        System.out.println("Done!");
    }

    private void retrieveCourseAndReviews(CourseService courseService) {
        int id = 4;
        Course course = courseService.findCourseAndReviewsByCourseId(id);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourseAndReview(CourseService courseService) {
        Course course = new Course("Database Design");
        course.addReview(new Review("Great course... Love it!"));
        course.addReview(new Review("Cool course, job well done."));
        course.addReview(new Review("What a dumb course, you are an idiot"));

        System.out.println("Saving the course");
        System.out.println(course);
        System.out.println(course.getReviews());

        courseService.save(course);
    }

    private void deleteCourseById(CourseService courseService) {
        int id = 1;
        System.out.println("Deleting course id: " + id);

        courseService.deleteById(id);

        System.out.println("Done!");
    }

    private void updateInstructor(InstructorService instructorService) {
        int id = 1;

        System.out.println("Finding Instructor Id: " + id);
        Instructor updatableInstructor = instructorService.findById(id);

        System.out.println("Updating Instructor Id: " + id);
        updatableInstructor.setLastName("Master");

        instructorService.save(updatableInstructor);
        System.out.println("Done!");
    }

    private void findInstructorByIdJoinFetch(InstructorService instructorService) {
        int id = 1;

        System.out.println("Finding the Instructor: " + id);
        Instructor instructor = instructorService.findInstructorByIdJoinFetch(id);
        System.out.println("Instructor: " + instructor);
        System.out.println("The Associate courses: " + instructor.getCourses());
        System.out.println("Done!");
    }

    private void findCoursesForInstructor(InstructorService instructorService, CourseService courseService) {
        int id = 1;
        System.out.println("Finding the instructor id: " + id);

        Instructor instructor = instructorService.findById(id);
        System.out.println("Instructor: " + instructor);

        System.out.println("Finding Courses for Instructor Id: " + id);
        List<Course> courseList = courseService.findCourseListByInstructorId(instructor.getId());

        // Associate the objects
        instructor.setCourses(courseList);

        System.out.println("The Associate Courses: " + instructor.getCourses());
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
