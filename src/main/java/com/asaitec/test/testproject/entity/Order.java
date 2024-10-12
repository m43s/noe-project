package com.asaitec.test.testproject.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders") 
@Setter
@Getter
@NoArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	private LocalDateTime date;

	private String clientName;

	private String description;

	@Setter(AccessLevel.NONE)
	private BigDecimal totalPrice;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderLine> orderLines;
	

	public void setTotalPrice() {
		this.totalPrice = calculateTotalPrice();
		
	}
	
	public BigDecimal calculateTotalPrice() {
		return orderLines.stream()
				.map(OrderLine::getTotalPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
