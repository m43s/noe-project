package com.asaitec.test.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asaitec.test.testproject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
