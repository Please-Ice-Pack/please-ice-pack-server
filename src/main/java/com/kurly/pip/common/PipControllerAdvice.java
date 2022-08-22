package com.kurly.pip.common;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class PipControllerAdvice {

	@ExceptionHandler(PipException.class)
	public ApiResponse<?> handlePipException(PipException e, HttpServletResponse response) {
		response.setStatus(e.getResultCode().getHttpStatus().value());
		log.info("pipException: {}", e.getMessage(), e);
		return ApiResponse.failure(e.getResultCode(), e.getResultCode().getMessage());
	}
}
