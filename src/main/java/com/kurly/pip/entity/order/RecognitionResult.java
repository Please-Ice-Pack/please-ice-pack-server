package com.kurly.pip.entity.order;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.kurly.pip.entity.BaseEntity;

import com.kurly.pip.entity.packing.Packing;
import com.kurly.pip.entity.packing.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecognitionResult extends BaseEntity {

	@Column(columnDefinition = "bigint not null")
	private Long orderId;

	@Column(columnDefinition = "bigint not null")
	private Long productId;

	private Integer amount;

	public static RecognitionResult of(
			Long orderId,
			Long productId,
			Integer amount
	) {
		return new RecognitionResult(orderId, productId, amount);
	}

	private RecognitionResult(
			Long orderId,
			Long productId,
			Integer amount
	) {
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
	}
}