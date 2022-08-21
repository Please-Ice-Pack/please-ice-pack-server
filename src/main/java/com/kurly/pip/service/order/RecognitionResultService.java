package com.kurly.pip.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kurly.pip.entity.order.RecognitionResult;
import com.kurly.pip.repository.order.RecognitionResultRepository;
import com.kurly.pip.service.product.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecognitionResultService {

    private final RecognitionResultRepository recognitionResultRepository;
    private final ProductService productService;

    public List<RecognitionResult> getAllByOrderId(Long orderId) {

        return recognitionResultRepository.getAllByOrderId(orderId);
    }
}