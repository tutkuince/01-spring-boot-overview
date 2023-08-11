package com.tutkuince.springcoredemo.rest;

import com.tutkuince.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // Define a private field for the dependency
    private final Coach myCoach;
    private final Coach anotherCoach;

    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach myCoach,
            @Qualifier("cricketCoach") Coach anotherCoach) {
        System.out.println("In Constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("check")
    public String check() {
        // If scope is Singleton, result is true. If scope is Prototype, result is false
        // Singleton: creates a single shared instance of the bean
        // Prototype: creates a new bean instance for each container request
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
