package com.newProject.Dto;

import lombok.Data;

@Data
public class CategoryDto {

    private long catId;
	private String catName;
	private CategoryDto parentCatId;
    
}
