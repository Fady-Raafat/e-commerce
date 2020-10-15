package com.example.demo.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.service.rest.api.ProductRestApi;
import com.example.demo.services.ProductService;
@RestController
public class ProductControllerRest  implements ProductRestApi{

	private ProductService productService;
	
	@Autowired
	public ProductControllerRest(ProductService productService) {
		this.productService=productService;
	}

	@Override
	public Page<Product> findAllProductsByPaginig(int start, int end) {
		return productService.findAllProductsByPaginig( start,  end);
	}

	@Override
	public Iterable<Product> findAll() {
		return productService.findAll();
	}

	@Override
	public Page<Product> sortingByNameAndUnitprice(int start, int end, String name, String unitPrice) {
		System.err.println(end);
		return productService.sortingByNameAndUnitprice(start, end, name, unitPrice);
	}

	@Override
	public Product findById(int id) {
		return productService.findById(id);
	}

	@Override
	public void save(Product product) {
		productService.save(product);
	}


	@Override
	public void delete(long id) {
		productService.delete(id);
	}
	
	
}
