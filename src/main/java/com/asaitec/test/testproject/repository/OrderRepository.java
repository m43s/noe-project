package com.asaitec.test.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asaitec.test.testproject.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
