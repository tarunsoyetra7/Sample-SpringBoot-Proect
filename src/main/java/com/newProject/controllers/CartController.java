package com.newProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newProject.models.Cart;
import com.newProject.services.CartService;

@RestController
public class CartController {

	@Autowired
	CartService cartservice;
	
	@PostMapping("Cart/add")
	public String addUser(@RequestParam Long userId,@RequestParam Long prdId,
			@RequestParam Long prdQuantity) {
		String response = cartservice.addCart(prdId, userId, prdQuantity);
		return response;
		
	}
	
	@PostMapping("Cart/update")
	public String addupdate(@RequestParam Long cartId,@RequestParam Long userId,@RequestParam Long prdId,
			@RequestParam Long prdQuantity) {
		String response = cartservice.addUpdate(cartId,prdId, userId, prdQuantity);
		return response;
		
	}
	
	@DeleteMapping("Cart/delete/{id}")
	public String deleteCart(@PathVariable int id) {
		String response = cartservice.deleteCart(id);
		return response;
	}
	
	@GetMapping("Cart/{id}")
	public List<Cart> getCartByUser(@PathVariable Long id){
		List<Cart> details = cartservice.getCartDetail(id);
		return details;
	}
	
}
