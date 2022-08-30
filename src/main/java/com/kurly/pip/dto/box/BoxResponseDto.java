package com.kurly.pip.dto.box;

import com.kurly.pip.entity.box.Type;
import com.kurly.pip.entity.packing.PackingBox;
import com.kurly.pip.entity.product.ColdType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoxResponseDto {
	private final String size;
	private final Integer amount;
	private final Type type;
	private final ColdType coldType;

	public static BoxResponseDto of(PackingBox packingBox) {
		return new BoxResponseDto(
			packingBox.getSize(),
			packingBox.getAmount(),
			packingBox.getType(),
			packingBox.getColdType()
		);
	}
}
