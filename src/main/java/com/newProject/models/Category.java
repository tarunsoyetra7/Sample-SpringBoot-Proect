package com.newProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category_master")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private long catId;
	@Column(name = "cat_name")
	private String catName;
	@Column(name = "parent_cat_id")
	private int parentCatId;
	
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public int getParentCatId() {
		return parentCatId;
	}
	public void setParentCatId(int parentCatId) {
		this.parentCatId = parentCatId;
	}


}
