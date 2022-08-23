package com.kurly.pip.service.packing;

import org.springframework.stereotype.Service;

import com.kurly.pip.entity.packing.RecognitionError;
import com.kurly.pip.repository.packing.RecognitionErrorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecognitionErrorService {

	private final RecognitionErrorRepository recognitionErrorRepository;

	public RecognitionError create(RecognitionError recognitionError) {

		return recognitionErrorRepository.save(recognitionError);
	}
}
