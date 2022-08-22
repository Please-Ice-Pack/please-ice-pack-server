package com.kurly.pip.dto.refrigerant;

import com.kurly.pip.entity.packing.PackingRefrigerant;
import com.kurly.pip.entity.refrigerant.Type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RefrigerantResponseDto {

    private final Type type;
    private final String size;
    private final Integer amount;

    public static RefrigerantResponseDto of(PackingRefrigerant packingRefrigerant) {
        return new RefrigerantResponseDto(
            packingRefrigerant.getType(),
            packingRefrigerant.getSize(),
            packingRefrigerant.getAmount()
        );
    }
}