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

    private Boolean isMatched;

    @Column(columnDefinition = "bigint not null")
    private Long orderId;

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;

    public static Packing of(
        Status status,
        Boolean isMatched,
        Long orderId
    ) {
        return new Packing(status, isMatched, orderId);
    }

    private Packing(
        Status status,
        Boolean isMatched,
        Long orderId
    ) {
        this.status = status;
        this.orderId = orderId;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }
}