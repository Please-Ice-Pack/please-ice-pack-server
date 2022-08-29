package com.kurly.pip.service.packing;

import org.springframework.stereotype.Service;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.packing.PackingBox;
import com.kurly.pip.repository.packing.PackingBoxRepository;
import com.kurly.pip.repository.packing.PackingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackingBoxService {

	private final PackingBoxRepository packingBoxRepository;
	private final PackingRepository packingRepository;

	public PackingBox create(PackingBox packingBox) {

		packingRepository.findById(packingBox.getPackingId())
			.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
		return packingBoxRepository.save(packingBox);
	}

	public PackingBox getByPackingIdOrThrow(Long packingId) {

		return packingBoxRepository.getByPackingId(packingId)
			.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
	}
}
