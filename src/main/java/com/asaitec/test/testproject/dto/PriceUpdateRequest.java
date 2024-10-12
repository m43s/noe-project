package com.asaitec.test.testproject.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PriceUpdateRequest {
	
	private Long productId;
	private BigDecimal newPrice;
}
