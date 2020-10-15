package com.example.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	@Query(value = "SELECT * FROM product where inventory >5", nativeQuery = true)
	Iterable<Product> findAllMoreThan5();

}
