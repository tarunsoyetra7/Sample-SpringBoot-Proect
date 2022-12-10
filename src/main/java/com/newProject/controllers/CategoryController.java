package com.newProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newProject.models.Category;

import com.newProject.services.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/saveCategory")
	public ResponseEntity<String> saveCategory(@RequestParam String catName, @RequestParam Long parentCatId) {
		String response = categoryService.saveCategoryDetails(catName, parentCatId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Category>> getProducts() {
		List<Category> response = categoryService.getAllCategories();
		if (response == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	@PostMapping("/updateCategory")
	public ResponseEntity<String> updateCategory(@RequestParam long catId, @RequestParam String catName,
			@RequestParam Long parentCatId) {
		String response = categoryService.updateCategoryDetails(catId, catName, parentCatId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
