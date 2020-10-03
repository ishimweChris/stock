package com.invetory.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.invetory.stock.dao.ProductDao;
import com.invetory.stock.domain.Product;

public class ProductService {
	@Autowired
	private ProductDao productdao; 
	
	public List<Product> findAll(){
		return productdao.findAll();
	}
	
}
