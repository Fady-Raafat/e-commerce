package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ProductCategory;
import com.example.demo.repositories.ProductCategoryRepository;
import com.example.demo.services.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	private ProductCategoryRepository productCategoryRepo;
	
	@Autowired
	public ProductCategoryServiceImpl (ProductCategoryRepository productCategoryRepo) {
		this.productCategoryRepo=productCategoryRepo;
	}
	
	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepo.findAll();
	}

	
	@Override
	public ProductCategory findById(long id) {
		return productCategoryRepo.findById(id).orElse(null);
	}

	@Override
	public void save(ProductCategory obj) {
		productCategoryRepo.save(obj);
	}

	@Override
	public void update(ProductCategory obj) {
		productCategoryRepo.save(obj);
	}

	@Override
	public void delete(long id) {
		productCategoryRepo.deleteById(id);
	}

}
