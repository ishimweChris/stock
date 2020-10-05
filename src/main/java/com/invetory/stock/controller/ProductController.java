package com.invetory.stock.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.invetory.stock.domain.Product;
import com.invetory.stock.domain.Unity;
import com.invetory.stock.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.invetory.stock.service.ProductService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productservice;

	@Autowired
	private ProductCategoryService categoryService;
	
	@RequestMapping(value="",method = RequestMethod.GET)
	public ResponseEntity<Object>  allProducts(HttpSession session,ModelMap model) {
		Map<String,Object> map=new HashMap<>();
		try{
			map.put("products",productservice.findByDeleted());
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}catch (Exception ex){
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}


	@RequestMapping(value="create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody InnerProduct innerProduct, HttpSession session, HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		try{

			Product product=new Product();
			product.setQuantity(innerProduct.quantity);
			product.setCategory(categoryService.findByUuid(innerProduct.categoryUuid));
			product.setUnit(Unity.valueOf(innerProduct.unit));
			product.setPrice(innerProduct.unityPrice);
			product.setName(innerProduct.name);
			productservice.save(product);
            map.put("code",200);
            map.put("object",productservice.save(product));
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}

	}


	@RequestMapping(value="delete/{uuid}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@PathVariable("uuid")String uuid, HttpSession session, HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		try{

			Product product=productservice.findByUuid(uuid);
			product.setDeletedStatus(true);
			productservice.save(product);
			map.put("code",200);
			map.put("object",productservice.save(product));
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}

	}

	@RequestMapping(value="quantity",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addQuantity(@RequestBody Map<String,Object> params, HttpSession session, HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		try{

			Product product=productservice.findOne(Long.parseLong(params.get("pid").toString()));
			product.setQuantity(product.getQuantity()+Double.parseDouble(params.get("qty").toString()));
			productservice.save(product);
			map.put("code",200);
			map.put("object",productservice.save(product));
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}catch (Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}

	}

	@RequestMapping(value="categories",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> viewProductCategory(HttpSession session, HttpServletRequest request){
		Map<String,Object> map=new HashMap<>();
		try{
           map.put("categories",categoryService.findAll());
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}catch (Exception ex){
			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}








	public static class   InnerProduct{
		private String name;
		private String categoryUuid;
		private String unit;
		private double quantity;
		private double unityPrice;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCategoryUuid() {
			return categoryUuid;
		}

		public void setCategoryUuid(String categoryUuid) {
			this.categoryUuid = categoryUuid;
		}

		public String getUnit() {
			return unit;
		}

		public void setUnit(String unit) {
			this.unit = unit;
		}

		public double getQuantity() {
			return quantity;
		}

		public void setQuantity(double quantity) {
			this.quantity = quantity;
		}

		public double getUnityPrice() {
			return unityPrice;
		}

		public void setUnityPrice(double unityPrice) {
			this.unityPrice = unityPrice;
		}
	}









}
