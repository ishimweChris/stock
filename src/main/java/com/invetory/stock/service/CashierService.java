package com.invetory.stock.service;

import java.util.List;

import com.invetory.stock.dao.CashierDao;
import com.invetory.stock.domain.Cashier;

public class CashierService {
	
	private CashierDao cashierdao;
	
	public List<Cashier> findAll(){
		return cashierdao.findAll();
	}

}
