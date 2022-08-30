package com.kurly.pip.facade.recognitionerror;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.dto.recognitionerror.RecognitionErrorRequestDto;
import com.kurly.pip.dto.recognitionerror.RecognitionErrorResponseDto;
import com.kurly.pip.entity.packing.RecognitionError;
import com.kurly.pip.service.packing.RecognitionErrorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RecognitionErrorFacadeService {

	private final RecognitionErrorService recognitionErrorService;

	@Transactional(readOnly = false)
	public RecognitionErrorResponseDto create(RecognitionErrorRequestDto dto) {

		return RecognitionErrorResponseDto.from(
			recognitionErrorService.create(
				RecognitionError.from(
					dto.getImageLink()
				)
			)
		);
	}
}
