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
public class ImageResult extends BaseEntity {

    @Column(columnDefinition = "bigint not null")
    private Long orderId;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    private Boolean result;
}