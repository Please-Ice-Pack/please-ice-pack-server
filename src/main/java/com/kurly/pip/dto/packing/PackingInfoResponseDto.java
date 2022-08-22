package com.kurly.pip.dto.packing;

import com.kurly.pip.entity.packing.Packing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PackingInfoResponseDto {

	private final Long packingId;
	private final Boolean isMatched;

	public static PackingInfoResponseDto from(Packing packing) {
		return new PackingInfoResponseDto(
			packing.getId(),
			packing.getIsMatched()
		);
	}
}
