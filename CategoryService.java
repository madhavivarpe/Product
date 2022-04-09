package com.edu.demo.service;

import java.util.List;

import com.edu.demo.entity.Category;

public interface CategoryService {


	public Category saveCategory(Category category);

	public List<Category> fetchtCategoryList();

	public Category fetchCategoryById(Long did);

	public void deleteCategoryById(Long did);

	public Category updateCategory(Long did, Category category);

	public Category fetchCategoryByName(String categoryName);

	


	}