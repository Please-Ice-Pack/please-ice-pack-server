package com.kurly.pip.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.kurly.pip.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseEntity {

    @Column(columnDefinition = "varchar(20) not null")
    private String customerName;

    @Column(columnDefinition = "varchar(20) not null")
    private String trackingNumber;

    @Column(columnDefinition = "varchar(255) not null")
    private String imageLink;
}
