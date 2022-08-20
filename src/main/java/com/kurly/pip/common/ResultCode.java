package com.kurly.pip.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultCode {
    SUCCESS(200, "성공"),

    // 공통
    BAD_REQUEST(400, "요청에 오류가 있습니다."),

    UNAUTHORIZED(401, "인증이 필요한 요청입니다."),

    FORBIDDEN(403, "허용되지 않은 접근입니다."),

    NOT_FOUND(404, "대상이 존재하지 않습니다."),

    INTERNAL_SERVER_ERROR(500, "서버에 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),

    ALREADY_EXISTS_IDENTIFICATION(400, "존재하는 아이디입니다.");

    private final Integer code;
    private final String message;
}
