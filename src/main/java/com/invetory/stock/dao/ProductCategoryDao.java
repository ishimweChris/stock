package com.invetory.stock.dao;

import com.invetory.stock.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Long> {


    public ProductCategory findByUuidAndDeletedStatus(String uuid,boolean ds);
}
