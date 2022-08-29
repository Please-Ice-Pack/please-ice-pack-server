package com.kurly.pip.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kurly.pip.entity.product.Product;
import com.kurly.pip.repository.product.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public List<Product> getByIds(List<Long> ids) {

		return productRepository.findByIdIn(ids);
	}
}
