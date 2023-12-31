package com.tutkuince.springboot.advancedjpa;

import com.tutkuince.springboot.advancedjpa.entity.Instructor;
import com.tutkuince.springboot.advancedjpa.entity.InstructorDetail;
import com.tutkuince.springboot.advancedjpa.service.InstructorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvancedJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(InstructorService instructorService) {
        return runner -> {
            // createInstructor(instructorService);
            // findInstructor(instructorService);
            deleteInstructorById(instructorService);
        };
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
