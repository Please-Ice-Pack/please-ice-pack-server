package com.kurly.pip.dto.packing;

import java.util.List;

import com.kurly.pip.dto.box.BoxResponseDto;
import com.kurly.pip.dto.refrigerant.RefrigerantResponseDto;

import lombok.Value;

@Value(staticConstructor = "of")
public class RecommendedPackingOptionResponseDto {

    private final BoxResponseDto box;
    private final List<RefrigerantResponseDto> refrigerants;
}
