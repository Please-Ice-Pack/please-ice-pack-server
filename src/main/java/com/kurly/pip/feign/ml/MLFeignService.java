package com.kurly.pip.feign.ml;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.feign.ml.dto.MLRequestDto;
import com.kurly.pip.feign.ml.dto.MLResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MLFeignService {

	private final MLFeignClient mlFeignClient;

	public MLResponseDto getRecognitionResults(MLRequestDto dto) {
		return mlFeignClient.getRecognitionResults(dto);
	}
}
