package com.kurly.pip.feign.ml.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class MLRecognitionResultResponseDto {

	Long orderId;
	List<OrderResults> order_results;
	List<DetectResults> detect_results;
	Boolean orderMatched;
	List<Boxes> recommendedPackingOption;
	List<Refrigerants> refrigerants;

	@Getter
	public static class OrderResults {

		private Long productId;
		private String productName;
		private Integer amount;
		private Integer cold_type;
		private Boolean isMatched;
	}

	@Getter
	public static class DetectResults {

		private Long productId;
		private String productName;
		private Integer amount;
		private Integer cold_type;
	}

	@Getter
	public static class Boxes {
		com.kurly.pip.entity.box.Type box_type;
		String box_size;
		String box_flag;
	}

	@Getter
	public static class Refrigerants {

		com.kurly.pip.entity.refrigerant.Type refrigerant_type;
		String refrigerant_size;
		Integer refrigerant_amount;
	}
}
