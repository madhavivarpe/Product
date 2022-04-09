package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.RecordNotFoundException;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategorys() {
		List<Category> list = service.getAllCategorys();

		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
	
	

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Category entity = service.getCategoryById(id);

		return new ResponseEntity<Category>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Category> createOrUpdateCategory(Category category)
			throws RecordNotFoundException {
		Category updated = service.createOrUpdateCategory(category);
		return new ResponseEntity<Category>(updated, HttpStatus.OK);
	}

	
	
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteCategoryById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteCategoryById(id);
		return HttpStatus.FORBIDDEN;
	}
}
