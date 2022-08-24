package com.kurly.pip.feign.ml.dto;

import java.util.List;

import lombok.Getter;

@Getter
public class MLRequestDto {

	private Long orderId;
	private List<ProductRequestDto> products;
	private String imageUrl;
}
