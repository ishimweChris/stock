package com.invetory.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invetory.stock.domain.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

}
