package com.kurly.pip.repository.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.order.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

	List<OrderProduct> getAllByOrderId(Long orderId);

	Optional<OrderProduct> findByOrderIdAndProductId(Long orderId, Long productId);
}
