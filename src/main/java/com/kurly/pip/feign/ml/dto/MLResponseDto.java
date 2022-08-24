package com.kurly.pip.feign.ml.dto;

import java.util.List;

public class MLResponseDto {

	Long orderId;
	OrderResultsDto order_results;
	DetectResultsDto detect_results;
	Boolean orderMatched;
	RecommendedPackingOptionDto recommendedPackingOption;
	List<Refrigerants> refrigerants;
}
