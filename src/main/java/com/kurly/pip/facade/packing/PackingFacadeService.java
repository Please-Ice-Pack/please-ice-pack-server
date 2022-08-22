package com.kurly.pip.facade.packing;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.dto.order.OrderResponseDto;
import com.kurly.pip.dto.packing.PackingResponseDto;
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

    /*
    작업자의 처리 되지 않은 패킹 데이터 조회
     */

    /*
    주문 번호로 조회
    */
    public PackingResponseDto getByOrderId(Long orderId) {

        Order order = orderService.getByOrderId(orderId);
        Packing packing = packingService.getByOrderIdOrThrow(orderId);
        checkPreProgressOrThrow(packing);

        packing.updateStatus(Status.IN_PROGRESS);

        return PackingResponseDto.of(
            OrderResponseDto.from(order),
            packing.getIsMatched(),
            productFacadeService.getOrderProductsByOrderId(orderId),
            productFacadeService.getRecognitionResultsByOrderId(orderId),
            recommendFacadeService.getByPackingId(packing.getId())
        );
    }

    private void checkPreProgressOrThrow(Packing packing) {

        if (!packing.getStatus().equals(Status.PRE_PROGRESS)) {
            throw new PipException(ResultCode.ALREADY_EXISTS_IDENTIFICATION);
        }
    }
}
