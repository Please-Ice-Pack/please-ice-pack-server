package com.kurly.pip.service.order;

import org.springframework.stereotype.Service;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.order.Order;
import com.kurly.pip.repository.order.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order getByOrderId(Long id) {

        return orderRepository.findById(id).orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
    }
}
