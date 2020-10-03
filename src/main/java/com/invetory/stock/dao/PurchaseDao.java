package com.invetory.stock.dao;

import com.invetory.stock.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDao extends JpaRepository<Purchase,Long> {
}
