package com.invetory.stock.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String uuid = UUID.randomUUID().toString();
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date doneAt = new Timestamp(new Date().getTime());
    private String doneBy = "";
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt; // = null;
    private String lastUpdatedBy = "";

    private boolean deletedStatus = false;
    private String name;
    private double price;
    private double boxNumber;
    private double itemNumber;
    @Enumerated(EnumType.STRING)
    private Unity unit; //
    private double quantity;

    private int itemInPackage;

    @ManyToOne
    private ProductCategory category;

    public int getItemInPackage() {
        return itemInPackage;
    }

    public void setItemInPackage(int itemInPackage) {
        this.itemInPackage = itemInPackage;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(double boxNumber) {
        this.boxNumber = boxNumber;
    }

    public double getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(double itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Unity getUnit() {
        return unit;
    }

    public void setUnit(Unity unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + "]";
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getDoneAt() {
        return doneAt;
    }

    public void setDoneAt(Date doneAt) {
        this.doneAt = doneAt;
    }

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public boolean isDeletedStatus() {
        return deletedStatus;
    }

    public void setDeletedStatus(boolean deletedStatus) {
        this.deletedStatus = deletedStatus;
    }
}
