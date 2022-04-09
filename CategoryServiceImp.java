package com.edu.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.demo.entity.Category;
import com.edu.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private  CategoryRepository  categoryRepository;
	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> fetchtCategoryList() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}
	

	@Override
	public Category fetchCategoryById(Long did) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(did).get();
	}
	
	

	@Override
	public void deleteCategoryById(Long did) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(did);
	}

	@Override
	public Category updateCategory(Long did, Category category) {
	
		Category catDB=categoryRepository.findById(did).get();
		if(Objects.nonNull(category.getCategoryName()) && !"".equalsIgnoreCase(category.getCategoryName())) {
			catDB.setCategoryName(category.getCategoryName());
			
		}
		
		return categoryRepository.save(catDB);
	}
		
	@Override
	public Category fetchCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		return categoryRepository.findByCategoryName(categoryName);
	}

}


