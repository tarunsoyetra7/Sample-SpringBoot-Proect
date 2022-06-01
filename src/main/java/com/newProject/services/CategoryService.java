package com.newProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.newProject.models.Category;

import com.newProject.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public String saveCategoryDetails(String catName, int parentCatId) {
		Category categoryDetail = new Category();
		categoryDetail.setCatName(catName);
		categoryDetail.setParentCatId(parentCatId);

		try {
			categoryRepository.save(categoryDetail);
			return "Data Saved Successfully ........";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<Category> getAllCategories() {
		List<Category> categoryDetails = categoryRepository.getAllCategories();
		return categoryDetails;
	}

	public String updateCategoryDetails(long catId, String catName, int parentCatId) {
		Optional<Category> optional = categoryRepository.findById(catId);
		if (optional.isPresent()) {
			Category categoryDetail = optional.get();
			categoryDetail.setCatId(catId);
			categoryDetail.setCatName(catName);
			categoryDetail.setParentCatId(parentCatId);
			try {
				categoryRepository.save(categoryDetail);
				return "Data Updated Successfully ........";
			} catch (Exception e) {
				return e.getMessage();
			}
		} else {
			return "No Data Found with Id :" + catId;
		}

	}

}
