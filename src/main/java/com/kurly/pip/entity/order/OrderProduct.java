package com.kurly.pip.entity.order;

import javax.persistence.Column;

import com.kurly.pip.entity.BaseEntity;

public class OrderProduct extends BaseEntity {

    @Column(columnDefinition = "bigint not null")
    private Long orderId;

    @Column(columnDefinition = "bigint not null")
    private Long productId;

    @Column(columnDefinition = "bigint not null")
    private Long imageResultId;
}
