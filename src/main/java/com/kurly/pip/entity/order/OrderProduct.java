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
public class OrderProduct extends BaseEntity {

	@Column(columnDefinition = "bigint not null")
	private Long orderId;

	@Column(columnDefinition = "bigint not null")
	private Long productId;

	private Integer amount;

	private Boolean isMatched;

	public static OrderProduct of(
			Long orderId,
			Long productId,
			Integer amount,
			Boolean isMatched
	) {
		return new OrderProduct(orderId, productId, amount, isMatched);
	}

	private OrderProduct(
			Long orderId,
			Long productId,
			Integer amount,
			Boolean isMatched
	) {
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.isMatched = isMatched;
	}

	public void updateIsMatched(Boolean isMatched) {
		this.isMatched = isMatched;
	}
}
