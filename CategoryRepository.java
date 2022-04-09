//Repository

package com.edu.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.demo.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	public Category findByCategoryName(String categoryName);

	
	
}