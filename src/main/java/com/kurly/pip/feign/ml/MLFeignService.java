package com.kurly.pip.feign.ml;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.feign.ml.dto.MLRecognitionResultResponseDto;
import com.kurly.pip.feign.ml.dto.RecognitionResultRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MLFeignService {

	private final MLFeignClient mlFeignClient;

	public MLRecognitionResultResponseDto getRecognitionResults(RecognitionResultRequestDto dto) {

		return mlFeignClient.getRecognitionResults(dto);
	}
}
