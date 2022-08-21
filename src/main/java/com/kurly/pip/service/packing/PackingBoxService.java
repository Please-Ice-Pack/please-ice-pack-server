package com.kurly.pip.service.packing;

import org.springframework.stereotype.Service;

import com.kurly.pip.repository.packing.PackingBoxRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PackingBoxService {

    private final PackingBoxRepository packingBoxRepository;
}
