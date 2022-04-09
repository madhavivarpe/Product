package com.example.demo.service;

//public class ProductService {

//}


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public List<Product> getAllproducts()
    {
        List<Product> productList = repository.findAll();
         
        if(productList.size() > 0) {
            return productList;
        } else {
            return new ArrayList<Product>();
        }
    }
	
	public Product getProductById(Long id) throws RecordNotFoundException 
    {
        Optional<Product> product = repository.findById(id);
         
        if(product.isPresent()) {
            return product.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Product createOrUpdateProduct(Product entity) throws RecordNotFoundException 
    {
        Optional<Product> product = repository.findById(entity.getId());
         
        if(product.isPresent()) 
        {
            Product newEntity = product.get();
            newEntity.setCat(entity.getCat());
            newEntity.setProd_name(entity.getProd_name());
            newEntity.setPrice(entity.getPrice());
 
            newEntity = repository.save(newEntity);
             
            return newEntity;
        } else {
            entity = repository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteProductById(Long id) throws RecordNotFoundException 
    {
        Optional<Product> product = repository.findById(id);
         
        if(product.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}
