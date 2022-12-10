package com.newProject.Dto;
import lombok.Data;

@Data
public class CartDto {
    
    private long cartId;
	private UserDto userId;
	private ProductDto prdId;
	private long prdQuantity;

}
