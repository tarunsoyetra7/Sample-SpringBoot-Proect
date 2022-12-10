package com.newProject.Dto;

import lombok.Data;

@Data
public class ProductDto {
    
    private Long prdId;
    private String prdName;
    private String prdDesc;
    private Long prdRate;
    private int prdAvail;
    private CategoryDto prdCatId;
    private int prdEd;  

}
