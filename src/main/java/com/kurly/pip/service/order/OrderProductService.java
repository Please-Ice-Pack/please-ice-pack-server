package com.kurly.pip.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.order.OrderProduct;
import com.kurly.pip.repository.order.OrderProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderProductService {

	private final OrderProductRepository orderProductRepository;

	public List<OrderProduct> getAllByOrderId(Long orderId) {

		return orderProductRepository.getAllByOrderId(orderId);
	}

	public OrderProduct findByOrderIdAndProductIdOrThrow(Long orderId, Long productId) {

		return orderProductRepository.findByOrderIdAndProductId(orderId, productId)
			.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
	}
}
