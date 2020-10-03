package com.invetory.stock.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(updatable = false)
    private String uuid = UUID.randomUUID().toString();
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date doneAt; // = new Timestamp(new Date().getTime());
    private String doneBy = "";
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt; // = null;
    private String lastUpdatedBy = "";

    private boolean deletedStatus = false;

    @ManyToOne
    private Product product;
    @Enumerated(EnumType.STRING)
    private Unity saleStatus; //ITEM,BOX

    private double quantity;

    private double unityPrice;


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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Unity getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(Unity saleStatus) {
        this.saleStatus = saleStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
