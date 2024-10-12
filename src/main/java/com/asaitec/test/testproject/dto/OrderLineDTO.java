package com.asaitec.test.testproject.dto;

import com.asaitec.test.testproject.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class OrderLineDTO {

	private Long productId;
	private int quantity;
	
	@JsonIgnore
	private Product product;

}
