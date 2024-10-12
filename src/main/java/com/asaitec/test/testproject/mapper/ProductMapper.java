package com.asaitec.test.testproject.mapper;

import org.springframework.stereotype.Component;

import com.asaitec.test.testproject.dto.ProductDTO;
import com.asaitec.test.testproject.entity.Product;

@Component
public class ProductMapper {

	public Product toEntity(ProductDTO productDTO) {
		
		if (productDTO == null) {
			return null;
		}

		Product product = new Product();
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());

		return product;
	}

}
