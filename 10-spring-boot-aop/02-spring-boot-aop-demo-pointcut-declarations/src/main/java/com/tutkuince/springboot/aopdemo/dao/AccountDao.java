package com.tutkuince.springboot.aopdemo.dao;

import com.tutkuince.springboot.aopdemo.entity.Account;

public interface AccountDao {
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
