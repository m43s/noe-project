package com.asaitec.test.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asaitec.test.testproject.entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
