package com.kurly.pip.service.order;

import java.util.List;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.order.OrderProduct;
import com.kurly.pip.entity.packing.Packing;
import com.kurly.pip.feign.ml.MLFeignService;
import com.kurly.pip.feign.ml.dto.MLRequestDto;
import com.kurly.pip.feign.ml.dto.MLResponseDto;
import com.kurly.pip.repository.order.OrderProductRepository;
import com.kurly.pip.repository.packing.PackingRepository;
import org.springframework.stereotype.Service;

import com.kurly.pip.entity.order.RecognitionResult;
import com.kurly.pip.repository.order.RecognitionResultRepository;
import com.kurly.pip.service.product.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RecognitionResultService {

    private final RecognitionResultRepository recognitionResultRepository;
    private final PackingRepository packingRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductService productService;
    private final MLFeignService mlFeignService;

    public List<RecognitionResult> getAllByOrderId(Long orderId) {

        return recognitionResultRepository.getAllByOrderId(orderId);
    }

    public String create(MLRequestDto dto) {

        MLResponseDto ml = mlFeignService.getRecognitionResults(dto);

        for(int i = 0; i < ml.getOrder_results().size(); i++){
            OrderProduct orderProduct = orderProductRepository.findByProductId(ml.getOrder_results().get(i).getProductId());
            orderProduct.updateIsMatched(ml.getOrder_results().get(i).getIsMatched());
        }

        for(int i = 0; i < ml.getDetect_results().size(); i++){
            RecognitionResult recognitionResult = RecognitionResult.of(dto.getOrderId(), ml.getDetect_results().get(i).getProductId(), ml.getDetect_results().get(i).getAmount());
            recognitionResultRepository.save(recognitionResult);
        }

        for(int i = 0; i < ml.getDetect_results().size(); i++){
            RecognitionResult recognitionResult = RecognitionResult.of(dto.getOrderId(), ml.getDetect_results().get(i).getProductId(), ml.getDetect_results().get(i).getAmount());
            recognitionResultRepository.save(recognitionResult);
        }

        Packing packing = packingRepository.getByOrderId(dto.getOrderId()).orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
        packing.updateIsMatched(ml.getOrderMatched());


        return "데이터가 저장되었습니다.";
    }
}