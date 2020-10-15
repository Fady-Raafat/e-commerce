package com.example.demo.services;

import java.util.Date;
import java.util.List;

import com.example.demo.entities.Discount;

public interface DiscountService {
	List<Discount> findAll();

	Discount findById(long id);

	void save(Discount obj);

	void update(Discount obj);

	void delete(long id);

	List<Discount> findAllBetwenDateFromAndDateTo(Date dateFrom , Date dateTo);


}
