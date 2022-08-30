package com.kurly.pip.facade.recognitionresult;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.entity.order.RecognitionResult;
import com.kurly.pip.entity.packing.Packing;
import com.kurly.pip.entity.packing.PackingBox;
import com.kurly.pip.entity.packing.PackingRefrigerant;
import com.kurly.pip.entity.packing.Status;
import com.kurly.pip.entity.product.ColdType;
import com.kurly.pip.feign.ml.MLFeignService;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultRequestDto;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultResponseDto;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultResponseDto.Boxes;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultResponseDto.DetectResults;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultResponseDto.OrderResults;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultResponseDto.Refrigerants;
import com.kurly.pip.service.order.OrderProductService;
import com.kurly.pip.service.packing.PackingBoxService;
import com.kurly.pip.service.packing.PackingRefrigerantService;
import com.kurly.pip.service.packing.PackingService;
import com.kurly.pip.service.recognitionresult.RecognitionResultService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RecognitionResultFacadeService {

	private final MLFeignService mlFeignService;
	private final OrderProductService orderProductService;
	private final RecognitionResultService recognitionResultService;
	private final PackingService packingService;
	private final PackingBoxService packingBoxService;
	private final PackingRefrigerantService packingRefrigerantService;

	@Transactional(readOnly = false)
	public String create(MLRecognitionResultRequestDto dto) {

		MLRecognitionResultResponseDto mlRecognitionResultResponseDto = mlFeignService.getRecognitionResults(dto);
		Long orderId = mlRecognitionResultResponseDto.getOrderId();
		List<OrderResults> orderResults = mlRecognitionResultResponseDto.getOrder_results();
		List<DetectResults> detectResults = mlRecognitionResultResponseDto.getDetect_results();
		List<Boxes> recommendedPackingOptions = mlRecognitionResultResponseDto.getRecommendedPackingOption();
		List<Refrigerants> refrigerants = mlRecognitionResultResponseDto.getRefrigerants();

		orderResults.forEach(
			orderResult ->
				orderProductService.findByOrderIdAndProductIdOrThrow(
					orderId,
					orderResult.getProductId()).updateIsMatched(orderResult.getIsMatched())
		);

		detectResults.forEach(
			detectResult ->
				recognitionResultService.create(
					RecognitionResult.of(
						orderId,
						detectResult.getProductId(),
						detectResult.getAmount()
					))
		);

		Packing packing = packingService.create(
			Packing.of(
				Status.PRE_PROGRESS,
				mlRecognitionResultResponseDto.getOrderMatched(),
				dto.getImageUrl(),
				orderId
			)
		);

		recommendedPackingOptions.forEach(
			box -> packingBoxService.create(
				PackingBox.of(
					packing.getId(),
					box.getBox_type(),
					box.getBox_size(),
					1,
					ColdType.ofFlag(box.getBox_flag())
				)
			)
		);

		refrigerants.forEach(
			refrigerant ->
				packingRefrigerantService.create(
					PackingRefrigerant.of(
						packing.getId(),
						refrigerant.getRefrigerant_type(),
						refrigerant.getRefrigerant_size(),
						refrigerant.getRefrigerant_amount()
					)
				)
		);

		return packing.getId() + "번 패킹데이터가 정상적으로 저장되었습니다.";
	}
}
