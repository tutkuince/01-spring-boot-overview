package com.tutkuince.springboot.aopdemo;

import com.tutkuince.springboot.aopdemo.dao.AccountDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDao accountDao) {
        return runner -> {
            demoTheBeforeAdvice(accountDao);
        };
    }

    private void demoTheBeforeAdvice(AccountDao accountDao) {
        // call the business method
        accountDao.addAccount();

        // one more time
        accountDao.addAccount();
    }
}
