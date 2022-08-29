package com.kurly.pip.service.packing;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.packing.PackingRefrigerant;
import com.kurly.pip.repository.packing.PackingRefrigerantRepository;
import com.kurly.pip.repository.product.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackingRefrigerantService {

	private final PackingRefrigerantRepository packingRefrigerantRepository;
	private final ProductRepository productRepository;

	public PackingRefrigerant create(PackingRefrigerant packingRefrigerant) {
		productRepository.findById(packingRefrigerant.getPackingId())
			.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));

		return packingRefrigerantRepository.save(packingRefrigerant);
	}

	public List<PackingRefrigerant> getAllByPackingId(Long packingId) {

		return packingRefrigerantRepository.getAllByPackingId(packingId);
	}
}
