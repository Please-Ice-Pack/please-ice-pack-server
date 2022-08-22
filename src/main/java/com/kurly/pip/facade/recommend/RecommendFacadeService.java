package com.kurly.pip.facade.recommend;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kurly.pip.dto.box.BoxResponseDto;
import com.kurly.pip.dto.packing.RecommendedPackingOptionResponseDto;
import com.kurly.pip.dto.refrigerant.RefrigerantResponseDto;
import com.kurly.pip.service.packing.PackingBoxService;
import com.kurly.pip.service.packing.PackingRefrigerantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendFacadeService {

    private final PackingBoxService packingBoxService;
    private final PackingRefrigerantService packingRefrigerantService;

    public RecommendedPackingOptionResponseDto getByPackingId(Long packingId) {

        return RecommendedPackingOptionResponseDto.of(
            BoxResponseDto.of(packingBoxService.getByPackingIdOrThrow(packingId)),
            packingRefrigerantService.getAllByPackingId(packingId)
                .stream()
                .map(RefrigerantResponseDto::of)
                .collect(Collectors.toList())
        );
    }
}
