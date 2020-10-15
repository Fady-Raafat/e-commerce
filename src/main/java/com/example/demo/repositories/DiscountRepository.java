package com.example.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long>{
	
	@Query(value = "SELECT * FROM discount where  date_from <=?1 and date_to >=?2 ", nativeQuery = true)
	List<Discount> findAllBetwenDateFromAndDateTo(Date dateFrom , Date dateTo);
	
}
