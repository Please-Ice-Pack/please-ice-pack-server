package com.kurly.pip.dto.packing;

import javax.validation.constraints.NotNull;

import com.kurly.pip.entity.packing.Status;

import lombok.Getter;

@Getter
public class UpdatePackingStatusRequestDto {

	@NotNull
	private Status status;
}
