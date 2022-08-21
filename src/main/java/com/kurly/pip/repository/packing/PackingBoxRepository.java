package com.kurly.pip.repository.packing;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.packing.PackingBox;

public interface PackingBoxRepository extends JpaRepository<PackingBox, Long> {
}
