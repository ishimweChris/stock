package com.invetory.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invetory.stock.domain.SystemUser;

@Repository
public interface SystemUserDao extends JpaRepository<SystemUser, Long> {

}
