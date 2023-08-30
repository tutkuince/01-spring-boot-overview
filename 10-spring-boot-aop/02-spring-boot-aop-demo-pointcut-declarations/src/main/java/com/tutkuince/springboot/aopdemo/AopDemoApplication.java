package com.tutkuince.springboot.aopdemo;

import com.tutkuince.springboot.aopdemo.dao.AccountDao;
import com.tutkuince.springboot.aopdemo.dao.MembershipDao;
import com.tutkuince.springboot.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class AopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {
        return runner -> {
            // demoTheBeforeAdvice(accountDao, membershipDao);
            demoTheAfterReturningAdvice(accountDao);
        };
    }

    private void demoTheAfterReturningAdvice(AccountDao accountDao) {
        // call method to find the accounts
        List<Account> accountList = accountDao.findAccounts();

        // display the accounts
        System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
        System.out.println("-----");
        System.out.println(accountList);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
        // call the business method
        accountDao.addAccount(new Account("Tutku Ince", "Master"), true);
        accountDao.doWork();

        // call the account dao getter/setter methods
        accountDao.setName("Northstar");
        accountDao.setServiceCode("Gold");

        String name = accountDao.getName();
        String serviceCode = accountDao.getServiceCode();

        // call the membership business method
        membershipDao.addSillyMember();
        membershipDao.goToSleep();
    }
}
