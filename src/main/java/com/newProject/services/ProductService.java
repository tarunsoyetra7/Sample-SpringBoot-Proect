package com.newProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.newProject.models.Product;
import com.newProject.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public String saveProductDetails(String prdName, String prdDesc, Long prdRate, int prdAvail, Long prdCatId) {
		Product productDetail = new Product();
		productDetail.setPrdName(prdName);
		productDetail.setPrdDesc(prdDesc);
		productDetail.setPrdRate(prdRate);
		productDetail.setPrdAvail(prdAvail);
		productDetail.setPrdCatId(prdCatId);

		try {
			productRepository.save(productDetail);
			return "Data Saved Successfully ........";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Product> getAllProducts() {
		List<Product> productDetails = productRepository.getAllProducts();
		return productDetails;

	}

	public Product getProductById(Long prdId) {
		Optional<Product> productDetails = productRepository.findById(prdId);
		Product product = new Product();
		product = productDetails.get();
		return product;
	}

	public String updateProductDetails(Long prdId, String prdName, String prdDesc, Long prdRate, int prdAvail,
			Long prdCatId) {

		Optional<Product> optional = productRepository.findById(prdId);
		if (optional.isPresent()) {
			Product productDetail = optional.get();
			productDetail.setPrdId(prdId);
			productDetail.setPrdName(prdName);
			productDetail.setPrdDesc(prdDesc);
			productDetail.setPrdRate(prdRate);
			productDetail.setPrdAvail(prdAvail);
			productDetail.setPrdCatId(prdCatId);
			try {
				productRepository.save(productDetail);
				return "Data Updated Successfully ........";
			} catch (Exception e) {
				return e.getMessage();
			}
		} else {
			return "No Data Found with Id :" + prdId;
		}
	}

  
	public String deleteProductById(Long prdId) {
		Optional<Product> optional = productRepository.check(prdId);
		if (optional.isPresent()) {
			productRepository.deleteById(prdId);
			return "Product Deleted Successfully .......";
		} else {
			return "No Data Found with Id : " + prdId;
		}
	}

}
