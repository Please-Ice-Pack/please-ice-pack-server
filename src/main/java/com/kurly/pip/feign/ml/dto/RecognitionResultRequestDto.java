package com.kurly.pip.feign.ml.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class RecognitionResultRequestDto {

	private Long orderId;
	private Boolean isPurpleBox;
	private List<ProductRequestDto> products;
	private String imageUrl;
}
