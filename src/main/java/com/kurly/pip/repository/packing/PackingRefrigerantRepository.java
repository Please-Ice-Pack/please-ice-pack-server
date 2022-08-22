package com.kurly.pip.repository.packing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.packing.PackingRefrigerant;

public interface PackingRefrigerantRepository extends JpaRepository<PackingRefrigerant, Long> {

    List<PackingRefrigerant> getAllByPackingId(Long packingId);
}
