package com.kurly.pip.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIdIn(List<Long> ids);
}
