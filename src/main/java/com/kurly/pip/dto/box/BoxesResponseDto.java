package com.kurly.pip.dto.box;

import java.util.List;

import lombok.Getter;
import lombok.Value;

@Getter
@Value(staticConstructor = "of")
public class BoxesResponseDto {

    List<BoxResponseDto> boxesResponse;
}
