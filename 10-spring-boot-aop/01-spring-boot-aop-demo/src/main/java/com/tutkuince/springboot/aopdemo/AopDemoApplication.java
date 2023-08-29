package com.tutkuince.springboot.aopdemo;

import com.tutkuince.springboot.aopdemo.dao.AccountDao;
import com.tutkuince.springboot.aopdemo.dao.MembershipDao;
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
    public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {
        return runner -> {
            demoTheBeforeAdvice(accountDao, membershipDao);
        };
    }

    private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
        // call the business method
        accountDao.addAccount();

        // call the membership business method
        membershipDao.addAccount();

    }
}
