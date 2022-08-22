package com.kurly.pip.service.packing;

import org.springframework.stereotype.Service;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.packing.Packing;
import com.kurly.pip.repository.packing.PackingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackingService {

    private final PackingRepository packingRepository;

    public Packing getByOrderIdOrThrow(Long orderId) {

        return packingRepository.getByOrderId(orderId).orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
    }

    public Packing create(Packing packing) {

        return packingRepository.save(packing);
    }
}
