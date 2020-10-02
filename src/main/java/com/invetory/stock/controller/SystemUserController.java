package com.invetory.stock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invetory.stock.service.SystemUserService;

@Controller
@RequestMapping("users")
public class SystemUserController {

	@Autowired
	private SystemUserService userService;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public String allUsers(HttpSession session,ModelMap model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
}
