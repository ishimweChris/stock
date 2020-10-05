package com.invetory.stock.service;

import com.invetory.stock.dao.ProductCategoryDao;
import com.invetory.stock.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryDao categoryDao;


    public ProductCategory findByUuid(String uuid){
        return categoryDao.findByUuidAndDeletedStatus(uuid,false);
    }

    public List<ProductCategory> findAll(){
        return categoryDao.findAll();
    }


}
