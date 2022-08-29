package com.kurly.pip.feign.ml.dto;

import com.kurly.pip.entity.box.Type;

import lombok.Getter;

@Getter
public class RecommendedPackingOptionDto {
	Type box_type;
	String box_size;
}
