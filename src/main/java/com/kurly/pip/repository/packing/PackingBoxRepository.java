package com.kurly.pip.repository.packing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.packing.PackingBox;

public interface PackingBoxRepository extends JpaRepository<PackingBox, Long> {

    Optional<PackingBox> getByPackingId(Long packingId);
}
