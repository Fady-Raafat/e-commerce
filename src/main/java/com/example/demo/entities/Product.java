package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Table(name = "product")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product  extends AbstractEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="unit_price")
	private double unitPrice;
	@Column(name="inventory")
	private long inventory;
	@Column(name="payment_options")
	private short paymentOptions;
	@Column(name="delivery")
	private short delivery;
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;
	
}
