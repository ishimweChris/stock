package com.invetory.stock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invetory.stock.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private ProductService productservice; 
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String allProducts(HttpSession session,ModelMap model) {
		model.addAttribute("product", productservice.findAll());
		return "products";
	}

}
