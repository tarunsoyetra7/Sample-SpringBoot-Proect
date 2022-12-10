package com.newProject.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.newProject.models.Cart;
import com.newProject.repositories.CartRepository;
import com.newProject.repositories.ProductRepository;
import com.newProject.repositories.UserRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	UserRepository userRepository;

	public String addCart(Long prdId, Long userId, Long prdQuantity) {
		Cart cart = new Cart();
		cart.setProduct(Arrays.asList(productRepository.findById(prdId).get()));
		cart.setPrdQuantity(prdQuantity);
		cart.setUser(userRepository.findById(userId).get());
		
		try{cartRepository.save(cart); 
		return "Data Saved Successfully";
	}catch(Exception e) {
		return e.getMessage();
	}
	}
	
	public String addUpdate(Long cartId,Long prdId, Long userId, Long prdQuantity) {
		Cart cart = new Cart();
		cart.setCartId(cartId);
		cart.setProduct(Arrays.asList(productRepository.findById(prdId).get()));
		cart.setPrdQuantity(prdQuantity);
		cart.setUser(userRepository.findById(userId).get());
		
		try{cartRepository.save(cart); 
		return "Data Updated Successfully";
	}catch(Exception e) {
		return e.getMessage();
	}
	}
	@Transactional
	public String deleteCart(int id) {
		String response;
		try {
			cartRepository.deleteById(id);
		    response= "Cart Deleted Successfully";
		}catch (Exception e) {
			response= "Cart Deleted Successfully";
		}
		return response;
	}

	public List<Cart> getCartDetail(Long id) {
		List<Cart> response = cartRepository.getCartDetailById(id);
		return response;
	}

}
