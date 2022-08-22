package com.kurly.pip.dto.refrigerant;

import java.util.List;

import lombok.Getter;
import lombok.Value;

@Getter
@Value(staticConstructor = "of")
public class RefrigerantsResponseDto {

    List<RefrigerantResponseDto> refrigerantsResponse;
}
