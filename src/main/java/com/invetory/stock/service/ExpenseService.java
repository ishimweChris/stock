package com.invetory.stock.service;

import com.invetory.stock.dao.ExpenseDao;
import com.invetory.stock.domain.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseDao expenseDao;


    public Expense save(Expense e) throws Exception{
     return expenseDao.save(e);
    }

    public Expense findByUuid(String uuid){
        return expenseDao.findByUuidAndDeletedStatus(uuid,false);
    }

    public List<Expense> findByDeleted(){
        return expenseDao.findByDeletedStatus(false);
    }
}
