package com.kurly.pip.feign.ml.dto;

import lombok.Getter;

@Getter
public class DetectResultsDto {

	private Long productId;
	private String productName;
	private Integer amount;
	private Integer cold_type;
}
