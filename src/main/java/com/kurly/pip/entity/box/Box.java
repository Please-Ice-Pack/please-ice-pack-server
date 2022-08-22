package com.kurly.pip.entity.box;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.kurly.pip.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Box extends BaseEntity {

    @Column(columnDefinition = "varchar(20) not null")
    private Integer width;

    @Column(columnDefinition = "varchar(20) not null")
    private Integer length;

    @Column(columnDefinition = "varchar(20) not null")
    private Integer height;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(20) not null")
    private Type type;

    //TODO: 박스 사이즈 확정되면 enum으로 관리
    @Column(columnDefinition = "varchar(20) not null")
    private String size;
}
