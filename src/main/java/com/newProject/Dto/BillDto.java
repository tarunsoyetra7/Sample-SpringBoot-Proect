package com.newProject.Dto;

import java.time.LocalDate;

public class BillDto {
    
    private Long billId;
    private Long userId;
    private String userName;
    private Long prdId;
    private String productName;
    private Long productQuan;
    private float productAmt;
    private LocalDate billDate;
    private Boolean isCancelled;
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

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getPrdId() {
        return this.prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductQuan() {
        return this.productQuan;
    }

    public void setProductQuan(Long productQuan) {
        this.productQuan = productQuan;
    }

    public float getProductAmt() {
        return this.productAmt;
    }

    public void setProductAmt(float productAmt) {
        this.productAmt = productAmt;
    }

    public LocalDate getBillDate() {
        return this.billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }
    
    public Boolean getIsCancelled() {
        return this.isCancelled;
    }

    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

}
