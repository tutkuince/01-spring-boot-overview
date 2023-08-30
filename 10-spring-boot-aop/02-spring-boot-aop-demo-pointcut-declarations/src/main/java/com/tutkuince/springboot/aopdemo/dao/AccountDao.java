package com.tutkuince.springboot.aopdemo.dao;

import com.tutkuince.springboot.aopdemo.entity.Account;

import java.util.List;

public interface AccountDao {
    // add a new method: findAccounts()
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
