package com.invetory.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invetory.stock.domain.Product;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {


    public List<Product> findByDeletedStatus(boolean ds);
    public Product findByUuidAndDeletedStatus(String uuid,boolean ds);
}
