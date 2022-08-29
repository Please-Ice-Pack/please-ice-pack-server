package com.kurly.pip.feign.ml.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class MLRecognitionResultResponseDto {

	Long orderId;
	List<OrderResultsDto> order_results;
	List<DetectResultsDto> detect_results;
	Boolean orderMatched;
	RecommendedPackingOptionDto recommendedPackingOption;
	List<Refrigerants> refrigerants;
}
