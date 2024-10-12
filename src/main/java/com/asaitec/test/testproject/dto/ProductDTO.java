package com.asaitec.test.testproject.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDTO {
	
    private Long productId;
    private String description;
    private BigDecimal price;

}
