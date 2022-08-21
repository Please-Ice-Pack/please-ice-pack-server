package com.kurly.pip.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
