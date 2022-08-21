package com.kurly.pip.dto.packing;

import com.kurly.pip.dto.order.OrderProductResponseDto;
import com.kurly.pip.dto.order.OrderResponseDto;
import com.kurly.pip.dto.order.RecognitionResultResponseDto;

import lombok.Value;

@Value(staticConstructor = "of")
public class PackingResponseDto {

    OrderResponseDto orderInfo;
    OrderProductResponseDto orderDetails;
    RecognitionResultResponseDto recognitionResults;
    RecommendedPackingOptionResponseDto recommendedPackingOption;
}
