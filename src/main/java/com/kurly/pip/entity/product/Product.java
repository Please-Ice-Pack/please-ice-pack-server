package com.kurly.pip.entity.product;

import javax.persistence.Column;
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

    @Column(columnDefinition = "varchar(255) not null")
    private String name;

    @Column(columnDefinition = "varchar(20) not null")
    private Integer volume;

    @Column(columnDefinition = "varchar(20) not null")
    private Integer width;

    @Column(columnDefinition = "varchar(20) not null")
    private Integer length;

    @Column(columnDefinition = "varchar(20) not null")
    private Integer height;

    @Convert(converter = ColdTypeConverter.class)
    @Column(columnDefinition = "varchar(20) not null")
    private ColdType coldType;
}
