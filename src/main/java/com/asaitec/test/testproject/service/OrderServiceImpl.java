package com.asaitec.test.testproject.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asaitec.test.testproject.dto.OrderDTO;
import com.asaitec.test.testproject.dto.OrderLineDTO;
import com.asaitec.test.testproject.dto.ProductDTO;
import com.asaitec.test.testproject.entity.Order;
import com.asaitec.test.testproject.entity.Product;
import com.asaitec.test.testproject.mapper.OrderMapper;
import com.asaitec.test.testproject.mapper.ProductMapper;
import com.asaitec.test.testproject.repository.OrderRepository;
import com.asaitec.test.testproject.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
    private OrderMapper orderMapper;
	
	@Autowired
    private ProductMapper productMapper;
	
	

	@Override
	public void createOrder(OrderDTO orderDTO) {
		  List<OrderLineDTO> updatedOrderLines = orderDTO.getOrderLines().stream()
	                .map(this::assignProductToOrderLine)
	                .collect(Collectors.toList());
		orderDTO.setOrderLines(updatedOrderLines);
		Order order = orderMapper.toEntity(orderDTO);
		orderRepository.save(order);
	}



	@Override
	public void createProducts(List<ProductDTO> products) {
		List<Product> productEntities = products.stream()
		        .map(productMapper::toEntity)
		        .collect(Collectors.toList());
		productRepository.saveAll(productEntities);
		
	}


	@Override
	public void updateProductPrice(Long productId, BigDecimal newPrice) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found"));
		product.setPrice(newPrice);
		productRepository.save(product);

	}
	
	private OrderLineDTO assignProductToOrderLine(OrderLineDTO orderLineDTO) {
		return Optional.ofNullable(orderLineDTO).map(ol -> {
			Product product = productRepository.findById(ol.getProductId())
					.orElseThrow(() -> new RuntimeException("Product not found with id: " + ol.getProductId()));
			ol.setProduct(product);
			return ol;
		}).orElseThrow(() -> new IllegalArgumentException("OrderLineDTO cannot be null"));
	}
	
	

}
