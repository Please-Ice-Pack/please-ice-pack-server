package com.kurly.pip.entity.refrigerant;

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
public class Refrigerant extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(20) not null")
	private Type type;

	//TODO: 냉매제 사이즈 확정되면 enum으로 관리
	@Column(columnDefinition = "varchar(10) null")
	private String size;
}
