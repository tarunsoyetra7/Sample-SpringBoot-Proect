package com.newProject.Dto;

import java.util.Date;

public class OfferDto{
    
    private long offerId;
    private long catId;
    private String catName;
    private Date offerSDate;
    private Date offerEDate;
    private int offerVal;

    public long getOfferId() {
        return this.offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public long getCatId() {
        return this.catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return this.catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Date getOfferSDate() {
        return this.offerSDate;
    }

    public void setOfferSDate(Date offerSDate) {
        this.offerSDate = offerSDate;
    }

    public Date getOfferEDate() {
        return this.offerEDate;
    }

    public void setOfferEDate(Date offerEDate) {
        this.offerEDate = offerEDate;
    }

    public int getOfferVal() {
        return this.offerVal;
    }

    public void setOfferVal(int offerVal) {
        this.offerVal = offerVal;
    }

}
