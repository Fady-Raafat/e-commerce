package com.example.demo.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Discount;
import com.example.demo.entities.Product;
import com.example.demo.services.CheckDiscountService;
import com.example.demo.services.DiscountService;
@Service
public class CheckDiscountServiceImpl implements CheckDiscountService{
	
	private DiscountService discountService;
	
	@Autowired
	public CheckDiscountServiceImpl( DiscountService discountService) {
		this.discountService = discountService;
	}

	@Override
	public Product checkForDiscount(Product product) {
		if(null ==product) {
			return null;
		}
		Date timeNow =serverTime();
		List<Discount> listDiscount = discountService.findAllBetwenDateFromAndDateTo(timeNow, timeNow);
		if(!listDiscount.isEmpty()) {
			double percentage = listDiscount.get(0).getPercentage();
			double afterPercentage = ((percentage/100)*product.getUnitPrice());
			product.setUnitPrice(product.getUnitPrice()-afterPercentage);
		}
		return product;
	}
	
	
	@Override
	public Page<Product> checkForDiscount(Page<Product> list) {
		Date timeNow =serverTime();
		List<Discount> listDiscount = discountService.findAllBetwenDateFromAndDateTo(timeNow, timeNow);
		if(!listDiscount.isEmpty()) {
				list.toList().forEach(i->{
					double percentage = listDiscount.get(0).getPercentage();
					double afterPercentage = ((percentage/100)*i.getUnitPrice());
					i.setUnitPrice(i.getUnitPrice()-afterPercentage);
				});
			}
		return list;
	}
	@Override
	public  Iterable<Product> checkForDiscount(Iterable<Product> list) {
		Date timeNow =serverTime();
		List<Discount> listDiscount = discountService.findAllBetwenDateFromAndDateTo(timeNow, timeNow);
		if(!listDiscount.isEmpty()) {
				list.forEach(i->{
					double percentage = listDiscount.get(0).getPercentage();
					double afterPercentage = ((percentage/100)*i.getUnitPrice());
					i.setUnitPrice(i.getUnitPrice()-afterPercentage);
				});
			}
		return list;
	}
	public Date serverTime() {
		LocalTime serverTime = LocalTime.now();
		return Timestamp.valueOf(serverTime.atDate(LocalDate.now()));
	}

}
