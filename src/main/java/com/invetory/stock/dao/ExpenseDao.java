package com.invetory.stock.dao;

import com.invetory.stock.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDao extends JpaRepository<Expense, Long> {

    public Expense findByUuidAndDeletedStatus(String uui,boolean d);
    public List<Expense> findByDeletedStatus(boolean d);

}
