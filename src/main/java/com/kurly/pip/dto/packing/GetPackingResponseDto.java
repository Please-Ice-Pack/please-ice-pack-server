package com.kurly.pip.dto.packing;

import java.util.List;

import com.kurly.pip.dto.order.OrderProductResponseDto;
import com.kurly.pip.dto.order.OrderResponseDto;
import com.kurly.pip.dto.order.RecognitionResultResponseDto;

import lombok.Value;

@Value(staticConstructor = "of")
public class GetPackingResponseDto {

	OrderResponseDto orderInfo;
	PackingInfoResponseDto packingInfo;
	List<OrderProductResponseDto> orderDetails;
	List<RecognitionResultResponseDto> recognitionResults;
	RecommendedPackingOptionResponseDto recommendedPackingOption;
}
