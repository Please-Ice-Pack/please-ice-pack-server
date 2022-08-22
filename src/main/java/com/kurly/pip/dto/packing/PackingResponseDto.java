package com.kurly.pip.dto.packing;

import com.kurly.pip.entity.packing.Packing;
import com.kurly.pip.entity.packing.Status;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PackingResponseDto {

	private final Long packingId;
	private final Status status;
	private final Boolean isMatched;
	private final Long employee;

	public static PackingResponseDto from(Packing packing) {
		return new PackingResponseDto(
			packing.getId(),
			packing.getStatus(),
			packing.getIsMatched(),
			packing.getUpdatedBy()
		);
	}
}
