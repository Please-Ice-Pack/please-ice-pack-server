package com.kurly.pip.repository.packing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.packing.Packing;

public interface PackingRepository extends JpaRepository<Packing, Long> {

    Optional<Packing> getByOrderId(Long orderId);

    Boolean existsByOrderId(Long orderId);
}
