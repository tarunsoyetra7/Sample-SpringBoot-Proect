package com.newProject.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_master")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id")
    private Long billId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "total_amount")
    private float billAmt;
    @Column(name = "product_id")
    private Long billProductId;
    @Column(name = "product_quan")
    private Long billProductQuan;
    @Column(name = "bill_date")
    private LocalDate billDate;
    @Column(name = "is_cancelled")
    private boolean isCancelled;


    public Long getBillId() {
        return this.billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public float getBillAmt() {
        return this.billAmt;
    }

    public void setBillAmt(float billAmt) {
        this.billAmt = billAmt;
    }

    public Long getBillProductId() {
        return this.billProductId;
    }

    public void setBillProductId(Long billProductId) {
        this.billProductId = billProductId;
    }
    
    public Long getBillProductQuan() {
        return this.billProductQuan;
    }

    public void setBillProductQuan(Long billProductQuan) {
        this.billProductQuan = billProductQuan;
    }

    public LocalDate getBillDate() {
        return this.billDate;
    }

    public void setBillDate(LocalDate localDate) {
        this.billDate = localDate;
    }

    public boolean isIsCancelled() {
        return this.isCancelled;
    }

    public void setIsCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

}
