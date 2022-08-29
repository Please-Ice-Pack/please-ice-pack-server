package com.kurly.pip.facade.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kurly.pip.dto.order.OrderProductResponseDto;
import com.kurly.pip.dto.order.RecognitionResultResponseDto;
import com.kurly.pip.entity.order.OrderProduct;
import com.kurly.pip.entity.order.RecognitionResult;
import com.kurly.pip.entity.product.Product;
import com.kurly.pip.service.order.OrderProductService;
import com.kurly.pip.service.product.ProductService;
import com.kurly.pip.service.recognitionresult.RecognitionResultService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductFacadeService {

	private final OrderProductService orderProductService;
	private final RecognitionResultService recognitionResultService;
	private final ProductService productService;

	public List<OrderProductResponseDto> getOrderProductsByOrderId(Long orderId) {
		List<OrderProduct> orderProducts = orderProductService.getAllByOrderId(orderId);
		List<Product> products = productService.getByIds(
			orderProducts
				.stream()
				.map(v -> v.getProductId())
				.collect(Collectors.toList())
		);

		List<OrderProductResponseDto> orderProductsResponse = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			orderProductsResponse.add(
				OrderProductResponseDto.of(
					products.get(i),
					orderProducts.get(i)
				));
		}

		return orderProductsResponse;
	}

	public List<RecognitionResultResponseDto> getRecognitionResultsByOrderId(Long orderId) {
		List<RecognitionResult> recognitionResults = recognitionResultService.getAllByOrderId(orderId);
		List<Product> products = productService.getByIds(
			recognitionResults
				.stream()
				.map(RecognitionResult::getProductId)
				.collect(Collectors.toList())
		);

		List<RecognitionResultResponseDto> recognitionResultsResponse = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			recognitionResultsResponse.add(
				RecognitionResultResponseDto.of(
					products.get(i),
					recognitionResults.get(i)
				));
		}

		return recognitionResultsResponse;
	}
}
