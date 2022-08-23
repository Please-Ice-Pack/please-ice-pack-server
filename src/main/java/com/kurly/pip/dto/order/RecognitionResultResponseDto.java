package com.kurly.pip.dto.order;

import com.kurly.pip.entity.order.RecognitionResult;
import com.kurly.pip.entity.product.ColdType;
import com.kurly.pip.entity.product.Product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecognitionResultResponseDto {

	private final Long productId;
	private final String productName;
	private final Integer amount;
	private final ColdType coldType;

	public static RecognitionResultResponseDto of(Product product, RecognitionResult recognitionResult) {
		return new RecognitionResultResponseDto(
			product.getId(),
			product.getName(),
			recognitionResult.getAmount(),
			product.getColdType()
		);
	}

}
