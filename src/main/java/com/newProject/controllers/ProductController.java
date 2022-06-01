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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.newProject.models.Product;
import com.newProject.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * 
	 * @param prdId
	 * @param prdName
	 * @param prdDesc
	 * @param prdRate
	 * @param prdAvail
	 * @param prdCatId
	 * @return saves the product in DB
	 */

	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestParam String prdName,
			@RequestParam String prdDesc, @RequestParam Long prdRate, @RequestParam int prdAvail,
			@RequestParam Long prdCatId) {
		//System.out.println(prdName + prdDesc + prdRate+ prdAvail + prdCatId);
		String response = productService.saveProductDetails(prdName, prdDesc, prdRate, prdAvail, prdCatId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Get all the products from DB
	 * @return all the products
	 */
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> response = productService.getAllProducts();
		if (response == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}
	
    @GetMapping("/getProductById/{prdId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long prdId){
    	Product response = productService.getProductById(prdId);
    	if (response == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
    }
    
    @PostMapping("/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestParam Long prdId, @RequestParam String prdName,
			@RequestParam String prdDesc, @RequestParam Long prdRate, @RequestParam int prdAvail,
			@RequestParam Long prdCatId){
        String response = productService.updateProductDetails(prdId, prdName, prdDesc, prdRate, prdAvail, prdCatId);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteProduct/{prdId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long prdId) {
        String respose = productService.deleteProductById(prdId);
        
        return new ResponseEntity<>(respose , HttpStatus.OK);
    }
    	

}
