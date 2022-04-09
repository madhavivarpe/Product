//Controller class

package com.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.demo.entity.Category;
import com.edu.demo.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired  //propertybased
private CategoryService categoryService;
//save
	@PostMapping("/categories/")
	public Category saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	//get all Category Record
	@GetMapping("/categories/")
	public List<Category> fetchCategoryList(){
		return categoryService.fetchtCategoryList();
	}
	
	//get Category by id
	@GetMapping("/categories/{id}")
	public Category fetchCategoryById(@PathVariable("id") Long did) {
		return categoryService.fetchCategoryById(did);
	}
	
	//delete
	@DeleteMapping("/categories/{id}")
	public String deleteCategoryById(@PathVariable("id") Long did) {
		categoryService.deleteCategoryById(did);
		return "Category deleted Successfully";
	}
	
	//update
	@PutMapping("/categories/{id}")
	public Category updateCategory(@PathVariable("id") Long did,@RequestBody Category category) {
		return categoryService.updateCategory(did,category);
	}
	
	//byname
	@GetMapping("/categories/name/{name}")
	public Category fetchCategoryByName(@PathVariable("name") String categoryName) {
		return categoryService.fetchCategoryByName(categoryName);
	}
	
	
	
}