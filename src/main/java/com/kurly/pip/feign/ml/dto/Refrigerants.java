package com.kurly.pip.feign.ml.dto;

import com.kurly.pip.entity.refrigerant.Type;

import lombok.Getter;

@Getter
public class Refrigerants {

	Type refrigerant_type;
	String refrigerant_size;
	Integer refrigerant_amount;
}
