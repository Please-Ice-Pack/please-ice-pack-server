package com.kurly.pip.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kurly.pip.entity.order.OrderProduct;
import com.kurly.pip.repository.order.OrderProductRepository;
import com.kurly.pip.service.product.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;
    private final ProductService productService;

    public List<OrderProduct> getAllByOrderId(Long orderId) {

        return orderProductRepository.getAllByOrderId(orderId);
    }
}
