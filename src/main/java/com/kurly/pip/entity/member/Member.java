package com.kurly.pip.entity.member;

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
public class Member extends BaseEntity {

    @Column(columnDefinition = "varchar(20) not null")
    String identification;

    @Column(columnDefinition = "varchar(20) not null")
    String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(10) not null")
    Role role;
}
