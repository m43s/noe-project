package com.asaitec.test.testproject.mapper;

import org.springframework.stereotype.Component;

import com.asaitec.test.testproject.dto.OrderLineDTO;
import com.asaitec.test.testproject.entity.OrderLine;

@Component
public class OrderLineMapper {

	public OrderLine toEntity(OrderLineDTO orderLineDTO) {
		
		if (orderLineDTO == null) {
			return null;
		}

		OrderLine orderLine = new OrderLine();
        
        orderLine.setProduct(orderLineDTO.getProduct());
        orderLine.setUnitPrice(orderLineDTO.getProduct().getPrice());
        orderLine.setQuantity(orderLineDTO.getQuantity());
        orderLine.setTotalPrice();

		return orderLine;
	}
	

}
