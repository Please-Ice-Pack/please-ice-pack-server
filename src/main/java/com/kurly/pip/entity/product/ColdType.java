package com.kurly.pip.entity.product;

import java.util.Arrays;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;

import lombok.Getter;

@Getter
public enum ColdType {
	NORMAL("상온", 0, "PUR"),
	REFRIGERATED("냉장", 1, "REF"),
	FROZEN("냉동", 2, "FRE");

	private final String desc;
	private final Integer code;
	private final String flag;

	ColdType(
		String desc,
		Integer code,
		String flag
	) {
		this.desc = desc;
		this.code = code;
		this.flag = flag;
	}

	public static ColdType ofCode(Integer code) {

		return Arrays.stream(ColdType.values())
			.filter(v -> v.getCode().equals(code))
			.findAny()
			.orElseThrow(() -> new PipException(ResultCode.INTERNAL_SERVER_ERROR));
	}

	public static ColdType ofFlag(String flag) {

		return Arrays.stream(ColdType.values())
			.filter(v -> v.getFlag().equals(flag))
			.findAny()
			.orElseThrow(() -> new PipException(ResultCode.INTERNAL_SERVER_ERROR));
	}
}
