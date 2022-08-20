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
    String name;

    @Column(columnDefinition = "varchar(20) not null")
    Integer volume;

    @Column(columnDefinition = "varchar(20) not null")
    Integer width;

    @Column(columnDefinition = "varchar(20) not null")
    Integer length;

    @Column(columnDefinition = "varchar(20) not null")
    Integer height;

    @Convert(converter = ColdTypeConverter.class)
    @Column(columnDefinition = "varchar(20) not null")
    Integer coldType;
}
