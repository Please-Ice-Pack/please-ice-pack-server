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
    @Column(columnDefinition = "varchar(20) not null")
    private Status status;

    private Boolean isMatched;

    @Column(columnDefinition = "varchar(255) not null")
    private String imageLink;

    @Column(columnDefinition = "bigint not null")
    private Long orderId;

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updatedBy;

    public static Packing of(
        Status status,
        Boolean isMatched,
        String imageLink,
        Long orderId
    ) {
        return new Packing(status, isMatched, imageLink, orderId);
    }

    private Packing(
        Status status,
        Boolean isMatched,
        String imageLink,
        Long orderId
    ) {
        this.status = status;
        this.isMatched = isMatched;
        this.imageLink = imageLink;
        this.orderId = orderId;
    }

    public void updateStatus(Status status) {
        this.status = status;
    }
}