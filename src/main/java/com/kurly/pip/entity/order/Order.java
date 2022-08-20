package com.kurly.pip.entity.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.kurly.pip.entity.BaseEntity;
import com.kurly.pip.entity.product.Product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Column(columnDefinition = "varchar(20) not null")
    private String customerName;

    @Column(columnDefinition = "varchar(20) not null")
    private String trackingNumber;

    @Column(columnDefinition = "varchar(255) not null")
    private String imageLink;

    @OneToMany
    private List<Product> products = new ArrayList<>();
}
