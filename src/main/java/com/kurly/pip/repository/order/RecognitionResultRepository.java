package com.kurly.pip.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.order.RecognitionResult;

public interface RecognitionResultRepository extends JpaRepository<RecognitionResult, Long> {

    List<RecognitionResult> getAllByOrderId(Long orderId);
}
