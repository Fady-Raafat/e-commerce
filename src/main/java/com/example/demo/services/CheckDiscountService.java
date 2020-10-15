package com.example.demo.services;


import org.springframework.data.domain.Page;

import com.example.demo.entities.Product;

public interface CheckDiscountService {

	Product checkForDiscount(Product product);

	Page<Product> checkForDiscount(Page<Product> list);

	Iterable<Product> checkForDiscount(Iterable<Product> list);

}
