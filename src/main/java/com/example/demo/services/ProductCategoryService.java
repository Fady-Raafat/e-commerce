package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.ProductCategory;

public interface ProductCategoryService {

	List<ProductCategory> findAll();

	ProductCategory findById(long id);

	void save(ProductCategory obj);

	void update(ProductCategory obj);

	void delete(long id);

}
