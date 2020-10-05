package com.invetory.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.invetory.stock.dao.ProductDao;
import com.invetory.stock.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao productdao; 
	
	public List<Product> findAll(){
		return productdao.findAll();
	}


	public Product save(Product p){
		return productdao.save(p);
	}

	public List<Product> findByDeleted(){
		return productdao.findByDeletedStatus(false);
	}

	public  Product findByUuid(String uuid){
		return productdao.findByUuidAndDeletedStatus(uuid,false);
	}

	public  Product findOne(long id){
		return productdao.getOne(id);
	}

	public void delete(Product p){
		productdao.delete(p);
	}

	
}
