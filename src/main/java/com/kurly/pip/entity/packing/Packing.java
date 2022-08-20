package com.kurly.pip.entity.packing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.kurly.pip.entity.BaseEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Packing extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) not null")
    private Status status;

    @Column(columnDefinition = "bigint not null")
    private Long orderId;

    @Column(columnDefinition = "bigint not null")
    private Long boxId;

    @Column(columnDefinition = "bigint not null")
    private Long refrigerantId;

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;
}