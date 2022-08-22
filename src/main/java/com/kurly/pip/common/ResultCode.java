package com.kurly.pip.common;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {
	SUCCESS(HttpStatus.OK, "성공"),

	// 공통
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "요청에 오류가 있습니다."),

	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "인증이 필요한 요청입니다."),

	FORBIDDEN(HttpStatus.FORBIDDEN, "허용되지 않은 접근입니다."),

	NOT_FOUND(HttpStatus.NOT_FOUND, "대상이 존재하지 않습니다."),

	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),

	// 멤버
	ALREADY_EXISTS_IDENTIFICATION(HttpStatus.BAD_REQUEST, "존재하는 아이디입니다."),
	LOGIN_INFO_NOT_EXISTS(HttpStatus.NOT_FOUND, "아이디 또는 패스워드가 일치하지 않습니다."),

	// 패킹
	NOT_PRE_PROGRESS_STATUS(HttpStatus.BAD_REQUEST, "해당 주문건은 이미 처리중입니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
