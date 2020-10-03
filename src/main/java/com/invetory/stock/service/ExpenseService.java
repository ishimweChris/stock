package com.invetory.stock.service;

import com.invetory.stock.dao.ExpenseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseDao expenseDao;
}
