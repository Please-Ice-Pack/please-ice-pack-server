package com.kurly.pip.service.recognitionresult;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.order.RecognitionResult;
import com.kurly.pip.repository.order.RecognitionResultRepository;
import com.kurly.pip.repository.product.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RecognitionResultService {

	private final RecognitionResultRepository recognitionResultRepository;
	private final ProductRepository productRepository;

	public List<RecognitionResult> getAllByOrderId(Long orderId) {

		return recognitionResultRepository.getAllByOrderId(orderId);
	}

	public RecognitionResult create(RecognitionResult recognitionResult) {

		productRepository.findById(recognitionResult.getProductId())
			.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
		return recognitionResultRepository.save(recognitionResult);
	}
}
// Packing packing = packingRepository.getByOrderId(dto.getOrderId())
// 	.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
// 	packing.updateIsMatched(ml.getOrderMatched());
//
// 		return "데이터가 저장되었습니다.";