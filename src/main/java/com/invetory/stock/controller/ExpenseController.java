package com.invetory.stock.controller;

import com.invetory.stock.domain.Expense;
import com.invetory.stock.domain.Product;
import com.invetory.stock.domain.Unity;
import com.invetory.stock.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;


    @RequestMapping(value="create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody InnerExpense innerExpense, HttpSession session, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try{

            Expense expense=new Expense();
            expense.setAmount(innerExpense.price);
            expense.setDescription(innerExpense.reason);
            expense.setName(innerExpense.name);
            System.out.println("djkf");
            map.put("code",200);
            map.put("object",expenseService.save(expense));
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }

    }




    public static class   InnerExpense{
        private String name;
        private double price;
        private String reason;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

}
