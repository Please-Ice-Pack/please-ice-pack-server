package com.kurly.pip.dto.order;

import java.time.LocalDateTime;

import com.kurly.pip.entity.order.Order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderResponseDto {

    private final Long orderId;
    private final String customerName;
    private final String trackingNumber;
    private final LocalDateTime orderDate;

    public static OrderResponseDto from(Order order) {
        return new OrderResponseDto(
            order.getId(),
            order.getCustomerName(),
            order.getTrackingNumber(),
            order.getCreatedAt()
        );
    }
}
