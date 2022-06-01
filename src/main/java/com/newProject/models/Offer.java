package com.newProject.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity()
@Table(name = "offer_master")
public class Offer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id")
    private long offerId;
    @Column(name = "cat_id")
    private Long catId;
    @Temporal(TemporalType.DATE)
    @Column(name = "offer_s_date")
    private Date offerSDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "offer_e_date")
    private Date offerEDate;
    @Column(name =  "offer_detail")
    private int offerVal;


    public long getOfferId() {
        return this.offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public Long getCatId() {
        return this.catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
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

    public int getofferVal() {
        return this.offerVal;
    }

    public void setofferVal(int offer_detail) {
        this.offerVal = offer_detail;
    }

}
