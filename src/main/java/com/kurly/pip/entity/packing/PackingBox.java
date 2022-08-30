package com.kurly.pip.entity.packing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.kurly.pip.entity.BaseEntity;
import com.kurly.pip.entity.box.Type;
import com.kurly.pip.entity.product.ColdType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackingBox extends BaseEntity {
	@Column(columnDefinition = "bigint not null")
	private Long packingId;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(20) not null")
	private Type type;

	//TODO: 박스 사이즈 확정되면 enum으로 관리
	@Column(columnDefinition = "varchar(20) not null")
	String size;

	private Integer amount;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(20) null")
	private ColdType coldType;

	public static PackingBox of(
		Long packingId,
		Type type,
		String size,
		Integer amount,
		ColdType coldType
	) {
		return new PackingBox(
			packingId,
			type,
			size,
			amount,
			coldType
		);
	}

	private PackingBox(
		Long packingId,
		Type type,
		String size,
		Integer amount,
		ColdType coldType
	) {
		this.packingId = packingId;
		this.type = type;
		this.size = size;
		this.amount = amount;
		this.coldType = coldType;
	}
}
