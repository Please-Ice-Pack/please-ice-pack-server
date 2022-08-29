package com.kurly.pip.facade.packing;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.dto.order.OrderResponseDto;
import com.kurly.pip.dto.packing.GetPackingResponseDto;
import com.kurly.pip.dto.packing.PackingInfoResponseDto;
import com.kurly.pip.dto.packing.PackingResponseDto;
import com.kurly.pip.dto.packing.UpdatePackingStatusRequestDto;
import com.kurly.pip.entity.order.Order;
import com.kurly.pip.entity.packing.Packing;
import com.kurly.pip.entity.packing.Status;
import com.kurly.pip.facade.product.ProductFacadeService;
import com.kurly.pip.facade.recommend.RecommendFacadeService;
import com.kurly.pip.service.order.OrderService;
import com.kurly.pip.service.packing.PackingService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PackingFacadeService {

	private final OrderService orderService;
	private final PackingService packingService;
	private final ProductFacadeService productFacadeService;
	private final RecommendFacadeService recommendFacadeService;

	public GetPackingResponseDto getByOrderId(Long orderId) {

		Order order = orderService.getByOrderId(orderId);
		Packing packing = packingService.getByOrderIdOrThrow(orderId);
		checkPreProgressOrThrow(packing);

		//TODO: 프론트 요청 사항으로 업데이트를 잠시 막아놓습니다. 결과물에는 삭제 필요
		// packing.updateStatus(Status.IN_PROGRESS);

		return GetPackingResponseDto.of(
			OrderResponseDto.from(order),
			PackingInfoResponseDto.from(packing),
			productFacadeService.getOrderProductsByOrderId(orderId),
			productFacadeService.getRecognitionResultsByOrderId(orderId),
			recommendFacadeService.getByPackingId(packing.getId())
		);
	}

	private void checkPreProgressOrThrow(Packing packing) {

		if (!packing.getStatus().equals(Status.PRE_PROGRESS)) {
			throw new PipException(ResultCode.NOT_PRE_PROGRESS_STATUS);
		}
	}

	@Transactional(readOnly = false)
	public PackingResponseDto updatePackingStatus(Long packingId, UpdatePackingStatusRequestDto dto) {

		packingService.getByIdOrThrow(packingId).updateStatus(dto.getStatus());
		return PackingResponseDto.from(packingService.getByOrderIdOrThrow(packingId));
	}
}
