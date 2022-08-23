package com.kurly.pip.dto.recognitionerror;

import com.kurly.pip.entity.packing.RecognitionError;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecognitionErrorResponseDto {

	private final Long id;
	private final String imageUrl;

	public static RecognitionErrorResponseDto from(RecognitionError recognitionError) {
		return new RecognitionErrorResponseDto(
			recognitionError.getId(),
			recognitionError.getImageLink()
		);
	}
}
