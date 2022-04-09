package com.example.demo.service;

//public class CategoryService {

//}
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;
	
	public List<Category> getAllCategorys()
    {
        List<Category> categoryList = repository.findAll();
         
        if(categoryList.size() > 0) {
            return categoryList;
        } else {
            return new ArrayList<Category>();
        }
    }
	
	public Category getCategoryById(Long id) throws RecordNotFoundException 
    {
        Optional<Category> Category = repository.findById(id);
         
        if(Category.isPresent()) {
            return Category.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Category createOrUpdateCategory(Category entity) throws RecordNotFoundException 
    {
        Optional<Category> category = repository.findById(entity.getId());
         
        if(category.isPresent()) 
        {
            Category newEntity = category.get();
            newEntity.setCat_name(entity.getCat_name());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteCategoryById(Long id) throws RecordNotFoundException 
    {
        Optional<Category> category = repository.findById(id);
         
        if(category.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}
