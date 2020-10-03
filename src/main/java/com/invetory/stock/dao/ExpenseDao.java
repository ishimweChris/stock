package com.invetory.stock.dao;

import com.invetory.stock.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long> {
}
