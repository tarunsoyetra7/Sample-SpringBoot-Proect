package com.newProject.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.newProject.Dto.ProductDto;
import com.newProject.Pojo.ResponseContent;
import com.newProject.models.Product;
import com.newProject.repositories.ProductRepository;
import com.newProject.services.ProductService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	ModelMapper mapper = new ModelMapper();

	@Override
	public ResponseContent saveProductDetails(ProductDto productDto) {
		log.info("Started Saving Product Data .......");
		Product productDetail = new Product();
		ResponseContent response = new ResponseContent();
		try {
			mapper.map(productDetail, Product.class);
			productRepository.save(productDetail);
			response.setStatusCode(200);
			response.setMessage("Data Saved Successfully");
			log.info("Product Data Saved Successfully .............");
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("Process Failed while saving data");
			log.error("Error Occured While Saving Product data", e.getMessage());	
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public ResponseContent getAllProducts() {
		log.info("Started Reteriving All the products data from db");
		ResponseContent content = new ResponseContent();
		List<ProductDto> productDtos = new ArrayList<>();
		try {
			List<Product> productDetails = productRepository.getAllProducts();
			mapper.map(productDetails, productDtos);
			if(productDetails.size() == 0){
				content.setStatusCode(404);
				log.info("No Product data found in db");
			} else{
				content.setStatusCode(200);
				log.info("Total {} data reterieved from db successfully",productDetails.size());
			}	
			content.setStatusCode(200);
		} catch (Exception e) {
			content.setStatusCode(500);
			log.error("Error Occured while Reteriving Product data", e.getMessage());	
			e.printStackTrace();
		}
		content.setProductDtoList(productDtos);
		return content;

	}

	@Override
	public ResponseContent getProductById(Long prdId) {
		log.info("Started Reteriving product data from db for id {}",prdId);
		ProductDto productDto = new ProductDto();
		ResponseContent responseContent = new ResponseContent();
		try {
			Optional<Product> productDetails = productRepository.findById(prdId);
			if (productDetails.isEmpty()) {
				responseContent.setStatusCode(404);
			} else {
				Product product = productDetails.get();
				mapper.map(product, productDto);
				responseContent.setStatusCode(200);
				log.info("Data Reterived Successfully from db for id {}",prdId);
			}
		} catch (Exception e) {
			responseContent.setStatusCode(500);
			log.error("Error Occured while Reteriving Product data", e.getMessage());	
			e.printStackTrace();
		}
		responseContent.setProductDtoList(Arrays.asList(productDto));
		return responseContent;
	}

	@Override
	public ResponseContent updateProductDetails(ProductDto productDto) {
		log.info("Started Updating product data for product {}",productDto.toString());
		ResponseContent response = new ResponseContent();
		try {
			Optional<Product> optional = productRepository.findById(productDto.getPrdId());
			if (optional.isPresent()) {
				Product productDetail = optional.get();
				mapper.map(productDetail, Product.class);
				productRepository.save(productDetail);
				response.setStatusCode(200);
				response.setMessage("Data Updated Successfully");
				log.info("Product Updated Successfully .............");
				return response;
			}	else {
				response.setStatusCode(404);
				response.setMessage("No Data Found for this Product to update");
				log.info("Product Data Updating Failed ..............");
				return response;
			}
		}  catch (Exception e) {
			response.setStatusCode(500);
			response.setMessage("Server Error Occured while Updating Data");
			log.error("Error Occured while Reteriving Product data", e.getMessage());	
			e.printStackTrace();
			return response;
		}
	}

	@Override
	public ResponseContent deleteProductById(Long prdId) {
		log.info("Started deleting product data for product id {}",prdId);
		ResponseContent response = new ResponseContent();
		try {
			Optional<Product> optional = productRepository.check(prdId);
			if (optional.isPresent()) {
				productRepository.deleteById(prdId);
				response.setMessage("Product Deleted Successfully");
				response.setStatusCode(200);
				log.info("Product Data Deleted Successfully ................");
				return response;
			} else {
				response.setStatusCode(404);
				response.setMessage("No Data Found for this product to Delete");
				log.info("No id = {} found to delete this Product ",prdId);
				return response;
			}
		} catch (Exception e) {
			response.setMessage("Server Error Occured while Deleteing the data");
			response.setStatusCode(500);
			log.error("Error Occured while Reteriving Product data", e.getMessage());	
			e.printStackTrace();
			return response;
		}
		
	}

}
