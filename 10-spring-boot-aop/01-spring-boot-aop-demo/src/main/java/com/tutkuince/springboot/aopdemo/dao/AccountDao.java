package com.tutkuince.springboot.aopdemo.dao;

import com.tutkuince.springboot.aopdemo.entity.Account;

public interface AccountDao {
    void addAccount(Account account, boolean vipFlag);
}
