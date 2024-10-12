package com.asaitec.test.testproject.service;

import java.math.BigDecimal;
import java.util.List;

import com.asaitec.test.testproject.dto.OrderDTO;
import com.asaitec.test.testproject.dto.ProductDTO;

public interface OrderService {
	
	void createOrder(OrderDTO request);
	
	void createProducts(List<ProductDTO> products);
	
	void updateProductPrice(Long productId, BigDecimal newPrice);

}
