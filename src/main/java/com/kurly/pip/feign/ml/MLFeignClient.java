package com.kurly.pip.feign.ml;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kurly.pip.config.feign.MLFeignClientConfig;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultRequestDto;
import com.kurly.pip.feign.ml.dto.MLRecognitionResultResponseDto;

@FeignClient(name = "mlFeignClient", url = "http://3.36.127.132", configuration = MLFeignClientConfig.class)
public interface MLFeignClient {

	@RequestMapping(method = RequestMethod.POST, value = "/files/")
	MLRecognitionResultResponseDto getRecognitionResults(@RequestBody MLRecognitionResultRequestDto dto);
}