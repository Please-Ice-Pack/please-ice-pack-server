package com.kurly.pip.service.recognitionresult;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.feign.ml.MLFeignService;
import com.kurly.pip.feign.ml.dto.MLRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RecognitionResultService {

	private final MLFeignService mlFeignService;

	public String create(MLRequestDto dto) {

		return "데이터가 저장되었스빈다.";
	}
}
