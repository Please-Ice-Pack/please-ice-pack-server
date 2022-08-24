package com.kurly.pip.feign.ml.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MLResponseDto {

	Long orderId;
	List<OrderResultsDto> order_results;
	List<DetectResultsDto> detect_results;
	Boolean orderMatched;
	RecommendedPackingOptionDto recommendedPackingOption;
	List<Refrigerants> refrigerants;
}
