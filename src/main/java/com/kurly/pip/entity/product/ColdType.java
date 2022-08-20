package com.kurly.pip.entity.product;

import java.util.Arrays;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;

import lombok.Getter;

@Getter
public enum ColdType {
    NORMAL("상온", 0),
    REFRIGERATED("냉장", 1),
    FROZEN("냉동", 2);

    private String desc;
    private Integer code;

    ColdType(
        String desc,
        Integer code
    ) {
        this.desc = desc;
        this.code = code;
    }

    public static ColdType ofCode(Integer code) {

        return Arrays.stream(ColdType.values())
            .filter(v -> v.getCode().equals(code))
            .findAny()
            .orElseThrow(() -> new PipException(ResultCode.INTERNAL_SERVER_ERROR));
    }
}
