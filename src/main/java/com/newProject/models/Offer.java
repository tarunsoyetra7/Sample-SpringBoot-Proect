package com.newProject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity()
@Table(name = "offer_master")
@Data
public class Offer{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offer_id")
    private long offerId;

    @ManyToMany
    @JoinColumn(name = "cat_id")
    private List<Category> categories;

    @Temporal(TemporalType.DATE)
    @Column(name = "offer_s_date")
    private Date offerSDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "offer_e_date")
    private Date offerEDate;

    @Column(name =  "offer_detail")
    private int offerVal;

}
