package com.kurly.pip.entity.product;

import javax.persistence.Convert;
import javax.persistence.Entity;

import com.kurly.pip.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    private String name;

    private Integer volume;

    private Integer width;

    private Integer length;

    private Integer height;

    @Convert(converter = ColdTypeConverter.class)
    private ColdType coldType;
}
