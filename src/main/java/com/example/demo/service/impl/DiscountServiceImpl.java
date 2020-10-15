package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Discount;
import com.example.demo.repositories.DiscountRepository;
import com.example.demo.services.DiscountService;
@Service
public class DiscountServiceImpl implements DiscountService{

	private DiscountRepository discountRepositroy;
	@Autowired
	public DiscountServiceImpl(DiscountRepository discountRepositroy) {
		this.discountRepositroy =discountRepositroy;
	}
	@Override
	public List<Discount> findAll() {
		return discountRepositroy.findAll();
	}

	@Override
	public Discount findById(long id) {
		return discountRepositroy.findById(id).orElse(null);
	}

	@Override
	public void save(Discount obj) {
		discountRepositroy.save(obj);
	}

	@Override
	public void update(Discount obj) {
		discountRepositroy.save(obj);
	}

	@Override
	public void delete(long id) {
		discountRepositroy.deleteById(id);
	}
	@Override
	public List<Discount> findAllBetwenDateFromAndDateTo(Date dateFrom, Date dateTo) {
		return discountRepositroy.findAllBetwenDateFromAndDateTo(dateFrom, dateTo);
	}

}
