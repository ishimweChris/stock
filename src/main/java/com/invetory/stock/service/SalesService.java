package com.invetory.stock.service;

import com.invetory.stock.dao.SalesDao;
import com.invetory.stock.domain.Product;
import com.invetory.stock.domain.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesDao salesDao;


    public Sales create(Sales s){
      return   salesDao.save(s);
    }

    public Sales findByUuid(String uuid){
        return salesDao.findByUuidAndDeletedStatus(uuid,false);
    }

    public List<Sales> findByProduct(Product p){
     return salesDao.findByProductAndAndDeletedStatus(p,false);
    }

    public List<Sales> findByDeleted(){
        return salesDao.findByDeletedStatus(false);
    }
}
