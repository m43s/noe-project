package com.asaitec.test.testproject.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asaitec.test.testproject.dto.OrderDTO;
import com.asaitec.test.testproject.entity.Order;
import com.asaitec.test.testproject.entity.OrderLine;

@Component
public class OrderMapper {
	
    @Autowired
    private OrderLineMapper orderLineMapper; 

	public Order toEntity(OrderDTO orderDTO) {

        if (orderDTO == null) {
            return null;
        }
        
		Order order = new Order();
		order.setDate(orderDTO.getDate());
		order.setClientName(orderDTO.getClientName());
		order.setDescription(orderDTO.getDescription());

		List<OrderLine> orderLines = orderDTO.getOrderLines().stream()
				.map(orderLineDTO -> {
					OrderLine orderLine = orderLineMapper.toEntity(orderLineDTO);
					orderLine.setOrder(order);
					return orderLine;
				})
				.collect(Collectors.toList());
		
		order.setOrderLines(orderLines);
		order.setTotalPrice();

		return order;
	}

}
