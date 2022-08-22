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
public class RecognitionError extends BaseEntity {

    @Column(columnDefinition = "bigint not null")
    private Long orderId;

    // TODO: 추후에 모델 디벨롭을 위해 어떤 데이터가 들어가야 할까(예: s3 url)
}
