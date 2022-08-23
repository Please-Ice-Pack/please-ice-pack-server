package com.kurly.pip.repository.packing;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kurly.pip.entity.packing.RecognitionError;

public interface RecognitionErrorRepository extends JpaRepository<RecognitionError, Long> {
	
}
