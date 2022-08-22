package com.kurly.pip.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class PipControllerAdvice {

	@ExceptionHandler(PipException.class)
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<?> handlePipException(PipException e) {
		log.info("handleIllegalArgumentException: {}", e.getMessage(), e);
		return ApiResponse.failure(e.getResultCode(), e.getMessage());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<?> handleIllegalArgumentException(IllegalArgumentException e) {
		log.info("handleIllegalArgumentException: {}", e.getMessage(), e);
		return ApiResponse.failure(ResultCode.BAD_REQUEST, e.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	public ApiResponse<?> handleException(Exception e) {
		log.error("handleException: {}", e.getMessage(), e);
		return ApiResponse.failure(ResultCode.INTERNAL_SERVER_ERROR);
	}
}
