package com.kurly.pip.facade.recommend;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.dto.box.BoxResponseDto;
import com.kurly.pip.dto.packing.RecommendedPackingOptionResponseDto;
import com.kurly.pip.dto.refrigerant.RefrigerantResponseDto;
import com.kurly.pip.service.packing.PackingBoxService;
import com.kurly.pip.service.packing.PackingRefrigerantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RecommendFacadeService {

	private final PackingBoxService packingBoxService;
	private final PackingRefrigerantService packingRefrigerantService;

	public RecommendedPackingOptionResponseDto getByPackingId(Long packingId) {

		return RecommendedPackingOptionResponseDto.of(
			packingBoxService.getAllByPackingId(packingId)
				.stream()
				.map(BoxResponseDto::of)
				.collect(Collectors.toList()),
			packingRefrigerantService.getAllByPackingId(packingId)
				.stream()
				.map(RefrigerantResponseDto::of)
				.collect(Collectors.toList())
		);
	}
}
