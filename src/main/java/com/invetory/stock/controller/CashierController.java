package com.invetory.stock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invetory.stock.service.CashierService;

@Controller
@RequestMapping("cashier")
public class CashierController {
	
	private CashierService cashierservice;  
	
	public String AllCashier(HttpSession session, ModelMap model) {
		model.addAttribute("cashier", cashierservice.findAll());
		return "cashier";
	}
}

