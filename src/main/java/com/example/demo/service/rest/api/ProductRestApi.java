package com.example.demo.service.rest.api;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.entities.Product;

@RequestMapping("/api")
public interface ProductRestApi {
	
	@GetMapping("/findallproductsby/{start}/{end}")
	@ResponseStatus(HttpStatus.FOUND)
	Page<Product> findAllProductsByPaginig(@PathVariable int start ,@PathVariable int end );
	
	@GetMapping("/findallproducts")
	@ResponseStatus(HttpStatus.FOUND)
	Iterable<Product> findAll();
	
	@GetMapping("/sortingallproducts/{start}/{end}/{name}/{unitPrice}")
	@ResponseStatus(HttpStatus.FOUND)
	Page<Product> sortingByNameAndUnitprice(@PathVariable int start,@PathVariable int end,@PathVariable String name,@PathVariable String unitPrice);
	
	@GetMapping("/findproduct/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	Product findById(@PathVariable int id);
	
	@PostMapping("/saveproduct")
	@ResponseStatus(HttpStatus.CREATED)
	void save(@RequestBody Product product);
	
	@DeleteMapping("/deleteproduct/{id}")
	@ResponseStatus(HttpStatus.OK)
	void delete(@PathVariable long id);

}
