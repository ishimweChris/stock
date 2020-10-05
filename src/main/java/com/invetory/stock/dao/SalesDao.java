package com.invetory.stock.dao;

import com.invetory.stock.domain.Product;
import com.invetory.stock.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesDao extends JpaRepository<Sales,Long> {

    public Sales findByUuidAndDeletedStatus(String uuid,boolean d);

    public List<Sales> findByDeletedStatus(boolean ds);

    public List<Sales> findByProductAndAndDeletedStatus(Product p,boolean ds);
}
