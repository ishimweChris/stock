package com.invetory.stock.controller;

import com.invetory.stock.service.ExpenseService;
import com.invetory.stock.service.ProductService;
import com.invetory.stock.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class WebController {

    @Autowired
    private ProductService productService;
    @Autowired
    private SalesService salesService;

    @Autowired
    private ExpenseService expenseService;


    @RequestMapping(value = "{option}",method = RequestMethod.GET)
    public String productPages(@PathVariable("option")String option, HttpSession session, ModelMap model){
       try{
          if(option.contains("products_list")){
              model.addAttribute("products",productService.findByDeleted());
              return "pages/Products";
          }else if(option.equalsIgnoreCase("sales_list")){
              model.addAttribute("sales",salesService.findByDeleted());
              return "pages/Sales";
          }else if(option.equalsIgnoreCase("make_sales")){
             return "pages/MakeSales";
          }else if(option.equalsIgnoreCase("expenses_list")){
              model.addAttribute("expenses",expenseService.findByDeleted());
              return "pages/expenses";
          }else if(option.equalsIgnoreCase("income_list")){
              return "pages/Income";
          }else{
              return "";
          }
       }catch (Exception e){
           e.printStackTrace();
         return "";
       }
    }
}
