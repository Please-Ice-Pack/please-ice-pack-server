package com.kurly.pip.entity.packing;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.kurly.pip.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackingBox extends BaseEntity {
    @Column(columnDefinition = "bigint not null")
    private Long packingId;

    //TODO: 박스 사이즈 확정되면 enum으로 관리
    @Column(columnDefinition = "varchar(20) not null")
    String size;

    private Integer amount;
}