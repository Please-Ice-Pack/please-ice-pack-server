package com.kurly.pip.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.kurly.pip.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ImageResult extends BaseEntity {

    @Column(columnDefinition = "bigint not null")
    private Long orderId;

    private Boolean isMatched;
}