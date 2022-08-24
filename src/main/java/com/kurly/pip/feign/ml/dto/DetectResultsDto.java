package com.kurly.pip.feign.ml.dto;

import lombok.Getter;

@Getter
public class DetectResultsDto {

	Long productId;
	String productName;
	Integer amount;
	Integer cold_type;
}
