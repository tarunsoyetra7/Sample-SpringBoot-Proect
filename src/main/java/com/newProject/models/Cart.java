package com.newProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity()
@Table(name = "cart_master")
@Data
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private long cartId;
	
	@JoinColumn(name="user_id")
	private User user;
	
	@JoinColumn(name="prd_id")
	private Product product;
	
	@Column(name="prd_quantity")
	private long prdQuantity;

}
