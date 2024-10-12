package com.asaitec.test.testproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asaitec.test.testproject.dto.OrderDTO;
import com.asaitec.test.testproject.dto.PriceUpdateRequest;
import com.asaitec.test.testproject.dto.ProductDTO;
import com.asaitec.test.testproject.service.OrderService;

@RestController
@RequestMapping("/order") // recomended -> "/orders"
public class OrderController {

	@Autowired
	private OrderService orderService;

	// Create an Order
	@PostMapping(value = "/createOrder") // recomended -> erase (value = "/createOrder")
	public ResponseEntity<String> createOrder(@RequestBody OrderDTO request) {
		try {
			orderService.createOrder(request);
			return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to create order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Create Products for an Order
	@PostMapping(value = "/addProducts") // recomended -> "/products"
	public ResponseEntity<String> addProducts(@RequestBody List<ProductDTO> products) {
		try {
			orderService.createProducts(products);
			return new ResponseEntity<>("Products created successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to create products: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Edit an Order
	@PutMapping(value = "/productPrice") // recomended -> "/<order-id>"
	public ResponseEntity<String> updateProductPrice(
			@RequestBody PriceUpdateRequest priceUpdateRequest) {
		try {
			orderService.updateProductPrice(priceUpdateRequest.getProductId(), priceUpdateRequest.getNewPrice());
			return new ResponseEntity<>("Product price updated successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to update product price: " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
