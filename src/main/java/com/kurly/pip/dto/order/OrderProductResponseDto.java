package com.kurly.pip.dto.order;

import com.kurly.pip.entity.order.OrderProduct;
import com.kurly.pip.entity.product.ColdType;
import com.kurly.pip.entity.product.Product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderProductResponseDto {

    private final Long productId;
    private final String productName;
    private final Integer amount;
    private final ColdType coldType;

    public static OrderProductResponseDto of(Product product, OrderProduct orderProduct) {
        return new OrderProductResponseDto(
            product.getId(),
            product.getName(),
            orderProduct.getAmount(),
            product.getColdType()
        );
    }
}
