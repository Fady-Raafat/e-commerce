package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepo;
	
	@Autowired
	public ProductServiceImpl( ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public Page<Product> sortingByNameAndUnitprice(int start, int end, String name, String unitPrice) {
		Pageable pageable = PageRequest.of(start, end, Sort.by(name).and(Sort.by(unitPrice)));
		return productRepo.findAll(pageable);
	}

	@Override
	public Iterable<Product> findAll() {
		return productRepo.findAllMoreThan5();	
		}

	@Override
	public Product findById(long id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public void save(Product obj) {
		productRepo.save(obj);
	}

	@Override
	public void update(Product obj) {
		productRepo.save(obj);
	}

	@Override
	public void delete(long id) {
		productRepo.deleteById(id);
	}

	@Override
	public Page<Product> findAllProductsByPaginig(int start, int end) {
		Pageable pageable = PageRequest.of(start, end);
		return productRepo.findAll(pageable);
	}
	
	

}
