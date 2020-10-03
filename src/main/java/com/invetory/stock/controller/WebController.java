package com.invetory.stock.controller;

import com.invetory.stock.service.ProductService;
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

    @RequestMapping(value = "{option}",method = RequestMethod.GET)
    public String productPages(@PathVariable("option")String option, HttpSession session, ModelMap model){
       try{
          if(option.contains("products_list")){
              model.addAttribute("products",productService.findByDeleted());
              return "product/Products";
          }else if(option.equalsIgnoreCase("sales_list")){
              return "product/Sales";
          }else if(option.equalsIgnoreCase("make_sales")){
             return "product/MakeSales";
          }else {
              return "";
          }
       }catch (Exception e){
         return "";
       }
    }
}