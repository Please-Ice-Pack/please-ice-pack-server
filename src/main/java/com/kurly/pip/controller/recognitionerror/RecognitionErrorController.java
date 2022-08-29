package com.kurly.pip.controller.recognitionerror;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.pip.common.ApiResponse;
import com.kurly.pip.dto.recognitionerror.RecognitionErrorRequestDto;
import com.kurly.pip.dto.recognitionerror.RecognitionErrorResponseDto;
import com.kurly.pip.facade.recognitionerror.RecognitionErrorFacadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/recognition-errors")
@RequiredArgsConstructor
@Api(tags = "인식 오류")
public class RecognitionErrorController {

	private final RecognitionErrorFacadeService recognitionErrorFacadeService;

	@ApiOperation("오류 데이터 저장 API")
	@PostMapping
	public ApiResponse<RecognitionErrorResponseDto> create(@RequestBody RecognitionErrorRequestDto dto) {

		return ApiResponse.success(recognitionErrorFacadeService.create(dto));
	}
}
