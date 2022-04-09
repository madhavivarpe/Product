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

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.RecordNotFoundException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> getAllproducts() {
		List<Product> list = service.getAllproducts();

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Product entity = service.getProductById(id);

		return new ResponseEntity<Product>(entity, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> createOrUpdateProduct(Product product)
			throws RecordNotFoundException {
		Product updated = service.createOrUpdateProduct(product);
		return new ResponseEntity<Product>(updated, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public HttpStatus deleteProductById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteProductById(id);
		return HttpStatus.FORBIDDEN;
	}
}
