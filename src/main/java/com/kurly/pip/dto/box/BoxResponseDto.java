package com.kurly.pip.dto.box;

import com.kurly.pip.entity.box.Type;
import com.kurly.pip.entity.packing.PackingBox;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoxResponseDto {
	private final String size;
	private final Integer amount;
	private final Type type;

	public static BoxResponseDto of(PackingBox packingBox) {
		return new BoxResponseDto(
			packingBox.getSize(),
			packingBox.getAmount(),
			packingBox.getType()
		);
	}
}
