package com.kurly.pip.service.packing;

import org.springframework.stereotype.Service;

import com.kurly.pip.repository.packing.PackingRefrigerantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackingRefrigerantService {

    private final PackingRefrigerantRepository packingRefrigerantRepository;
}
