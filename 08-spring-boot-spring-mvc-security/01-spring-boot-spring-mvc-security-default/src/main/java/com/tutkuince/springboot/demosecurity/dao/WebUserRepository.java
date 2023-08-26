package com.tutkuince.springboot.demosecurity.dao;

import com.tutkuince.springboot.demosecurity.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
}
