package com.newProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_master")
@Data
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

	@OneToOne
	@JoinColumn(name = "prd_cat_id")
	private Category category;
	
	@Column(name = "prd_ed")
	private int prdEd;


}
