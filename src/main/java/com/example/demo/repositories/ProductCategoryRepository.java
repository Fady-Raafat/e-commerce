package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.ProductCategory;


public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
