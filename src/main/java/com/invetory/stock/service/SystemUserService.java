package com.invetory.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invetory.stock.dao.SystemUserDao;
import com.invetory.stock.domain.SystemUser;

@Service
public class SystemUserService {

	@Autowired
	private SystemUserDao userDao;
	
	
	public List<SystemUser> findAll(){
		return userDao.findAll();
	}
	
	
}
