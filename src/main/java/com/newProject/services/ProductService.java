package com.newProject.services;

import org.springframework.stereotype.Service;
import com.newProject.Dto.ProductDto;
import com.newProject.Pojo.ResponseContent;

@Service
public interface ProductService {

    public ResponseContent saveProductDetails(ProductDto productDto);

    public ResponseContent getAllProducts();

    public ResponseContent getProductById(Long prdId);

    public ResponseContent updateProductDetails(ProductDto productDto);

    public ResponseContent deleteProductById(Long prdId);
    
}
