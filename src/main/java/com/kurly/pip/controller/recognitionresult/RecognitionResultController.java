package com.kurly.pip.controller.recognitionresult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.pip.common.ApiResponse;
import com.kurly.pip.facade.recognitionresult.RecognitionResultFacadeService;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultRequestDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/recognition-results")
@RequiredArgsConstructor
@Api(tags = "인식 결과")
public class RecognitionResultController {

	private final RecognitionResultFacadeService recognitionResultFacadeService;

	@ApiOperation("인식 결과 데이터 저장 API")
	@PostMapping
	public ApiResponse<String> create(@RequestBody MLRecognitionResultRequestDto dto) {

		return ApiResponse.success(recognitionResultFacadeService.create(dto));
	}
}
