package com.kurly.pip.entity.box;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.kurly.pip.entity.BaseEntity;

public class Box extends BaseEntity {

    @Column(columnDefinition = "varchar(20) not null")
    Integer width;

    @Column(columnDefinition = "varchar(20) not null")
    Integer length;

    @Column(columnDefinition = "varchar(20) not null")
    Integer height;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) not null")
    Type type;
}
