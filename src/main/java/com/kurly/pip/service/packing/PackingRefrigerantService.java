package com.kurly.pip.service.packing;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kurly.pip.entity.packing.PackingRefrigerant;
import com.kurly.pip.repository.packing.PackingRefrigerantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackingRefrigerantService {

    private final PackingRefrigerantRepository packingRefrigerantRepository;

    public List<PackingRefrigerant> getAllByPackingId(Long packingId) {

        return packingRefrigerantRepository.getAllByPackingId(packingId);
    }
}
