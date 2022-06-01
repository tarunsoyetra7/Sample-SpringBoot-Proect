package com.newProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_master")
public class Product {
  
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "prd_id")
private Long prdId;
@Column(name = "prd_name")
private String prdName;
@Column(name = "prd_desc")
private String prdDesc;
@Column(name = "prd_rate")
private Long prdRate;
@Column(name = "prd_avail")
private int prdAvail;
@Column(name = "prd_cat_id")
private Long prdCatId;
@Column(name = "prd_ed")
private int prdEd;

public Long getPrdId() {
	return prdId;
}
public void setPrdId(Long prdId) {
	this.prdId = prdId;
}
public String getPrdName() {
	return prdName;
}
public void setPrdName(String prdName) {
	this.prdName = prdName;
}
public String getPrdDesc() {
	return prdDesc;
}
public void setPrdDesc(String prdDesc) {
	this.prdDesc = prdDesc;
}
public Long getPrdRate() {
	return prdRate;
}
public void setPrdRate(Long prdRate) {
	this.prdRate = prdRate;
}
public int getPrdAvail() {
	return prdAvail;
}
public void setPrdAvail(int prdAvail) {
	this.prdAvail = prdAvail;
}
public Long getPrdCatId() {
	return prdCatId;
}
public void setPrdCatId(Long prdCatId) {
	this.prdCatId = prdCatId;
}
public int getPrdEd() {
	return prdEd;
}
public void setPrdEd(int prdEd) {
	this.prdEd = prdEd;
}

}
