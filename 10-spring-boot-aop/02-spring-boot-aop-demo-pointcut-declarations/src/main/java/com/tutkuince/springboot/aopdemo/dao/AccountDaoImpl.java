package com.tutkuince.springboot.aopdemo.dao;

import com.tutkuince.springboot.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        List<Account> accountList = new ArrayList<>();
        // create sample accounts
        Account acc1 = new Account("John", "Silver");
        Account acc2 = new Account("Neo", "Mat");
        Account acc3 = new Account("Luca", "Changretta");

        accountList.add(acc1);
        accountList.add(acc2);
        accountList.add(acc3);

        // add them to our accounts list
        return accountList;
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
