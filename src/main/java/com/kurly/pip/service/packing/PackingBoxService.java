package com.kurly.pip.service.packing;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.packing.PackingBox;
import com.kurly.pip.repository.packing.PackingBoxRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackingBoxService {

	private final PackingBoxRepository packingBoxRepository;

	public PackingBox create(PackingBox packingBox) {

		return packingBoxRepository.save(packingBox);
	}

	public PackingBox getByPackingIdOrThrow(Long packingId) {

		return packingBoxRepository.getByPackingId(packingId)
			.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
	}

	public List<PackingBox> getAllByPackingId(Long packingId) {

		return packingBoxRepository.getAllByPackingId(packingId);
	}
}
