package com.example.demo.services;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Product;

public interface ProductService {

	Iterable<Product> findAll();

	Product findById(long id);

	void save(Product obj);

	void update(Product obj);

	void delete(long id);

	Page<Product> findAllProductsByPaginig(int start, int end);

	Page<Product> sortingByNameAndUnitprice(int start, int end, String name, String unitPrice);
}
