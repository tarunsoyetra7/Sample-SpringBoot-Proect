package com.newProject.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.newProject.Dto.ProductDto;
import com.newProject.Pojo.ResponseContent;
import com.newProject.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
		ResponseContent response = new ResponseContent();
		response = productService.saveProductDetails(productDto);
		if (response.getStatusCode() == 200) {
			return new ResponseEntity<>(response.getMessage(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getProducts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductDto>> getProducts() {
		ResponseContent response = productService.getAllProducts();
		if (response.getStatusCode() == 200) {
			return new ResponseEntity<>(response.getProductDtoList(), HttpStatus.NOT_FOUND);
		} else if(response.getStatusCode() == 404) {
			return new ResponseEntity<>(response.getProductDtoList(), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(response.getProductDtoList(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
    @GetMapping("/getProductById/{prdId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long prdId){
    	ResponseContent response = productService.getProductById(prdId);
    	if (response.getStatusCode() == 200) {
			return new ResponseEntity<>(response.getProductDtoList().get(0), HttpStatus.NOT_FOUND);
		} else if(response.getStatusCode() == 404) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
    @PostMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto){
        ResponseContent response = productService.updateProductDetails(productDto);
		if (response.getStatusCode() == 200) {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.OK);
		} else if(response.getStatusCode() == 404) {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);	
		}
    }
    
    @DeleteMapping("/deleteProduct/{prdId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long prdId) {
        ResponseContent response = productService.deleteProductById(prdId);
        if (response.getStatusCode() == 200) {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.OK);
		} else if(response.getStatusCode() == 404) {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(response.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);	
		}
    }
	
}
