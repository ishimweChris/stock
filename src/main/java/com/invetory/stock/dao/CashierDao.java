package com.invetory.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invetory.stock.domain.Cashier;

@Repository
public interface CashierDao extends JpaRepository<Cashier, Long> {

}
