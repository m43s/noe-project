package com.asaitec.test.testproject.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderLineId;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	private int quantity;
	
	private BigDecimal unitPrice;
	
	@Setter(AccessLevel.NONE)
	private BigDecimal totalPrice;
	
	
	public void setTotalPrice() {
		this.totalPrice = calculateTotalPrice();
		
	}
	public BigDecimal calculateTotalPrice() {
		return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }





}
