package com.kurly.pip.controller.recognitionresult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.pip.common.ApiResponse;
import com.kurly.pip.feign.ml.dto.MLRequestDto;
import com.kurly.pip.service.recognitionresult.RecognitionResultService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/recognition-results")
@RequiredArgsConstructor
public class RecognitionResultController {

	private final RecognitionResultService recognitionResultService;

	@ApiOperation("인식 결과 데이터 저장 API")
	@PostMapping
	public ApiResponse<String> create(@RequestBody MLRequestDto dto) {

		return ApiResponse.success(recognitionResultService.create(dto));
	}
}
