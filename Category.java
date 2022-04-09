package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="cat_name")
	private String cat_name;
	

	public Category(){
		
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.cat_name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name2) {
		// TODO Auto-generated method stub
		
	}
}