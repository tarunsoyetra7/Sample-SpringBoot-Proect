package com.newProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "cart_master")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private long cartId;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="prd_id")
	private long prdId;
	
	@Column(name="prd_quantity")
	private long prdQuantity;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getPrdId() {
		return prdId;
	}

	public void setPrdId(long prdId) {
		this.prdId = prdId;
	}

	public long getPrdQuantity() {
		return prdQuantity;
	}

	public void setPrdQuantity(long prdQuantity) {
		this.prdQuantity = prdQuantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", prdId=" + prdId + ", prdQuantity=" + prdQuantity
				+ "]";
	}
}
