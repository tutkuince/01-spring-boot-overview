package com.tutkuince.springcoredemo.config;

import com.tutkuince.springcoredemo.common.Coach;
import com.tutkuince.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic") // Custom Bean Id
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
