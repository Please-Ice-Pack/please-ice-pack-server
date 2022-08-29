package com.kurly.pip.entity.packing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.kurly.pip.entity.BaseEntity;
import com.kurly.pip.entity.refrigerant.Type;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PackingRefrigerant extends BaseEntity {
	@Column(columnDefinition = "bigint not null")
	private Long packingId;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(20) not null")
	private Type type;

	//TODO: 냉매제 사이즈 확정되면 enum으로 관리
	@Column(columnDefinition = "varchar(10) null")
	private String size;

	private Integer amount;

	public static PackingRefrigerant of(
		Long packingId,
		Type type,
		String size,
		Integer amount
	) {
		return new PackingRefrigerant(
			packingId,
			type,
			size,
			amount
		);
	}

	private PackingRefrigerant(
		Long packingId,
		Type type,
		String size,
		Integer amount
	) {
		this.packingId = packingId;
		this.type = type;
		this.size = size;
		this.amount = amount;
	}
}
