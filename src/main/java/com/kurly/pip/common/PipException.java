package com.kurly.pip.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PipException extends RuntimeException {

    private final ResultCode resultCode;
}
