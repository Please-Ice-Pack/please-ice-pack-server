package com.kurly.pip.controller.packing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.pip.common.ApiResponse;
import com.kurly.pip.dto.packing.GetPackingResponseDto;
import com.kurly.pip.dto.packing.PackingResponseDto;
import com.kurly.pip.dto.packing.UpdatePackingStatusRequestDto;
import com.kurly.pip.facade.packing.PackingFacadeService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/packings")
@RequiredArgsConstructor
public class PackingController {

	private final PackingFacadeService packingFacadeService;

	@ApiOperation("패킹 데이터 조회 API")
	@GetMapping("orders/{orderId}")
	public ApiResponse<GetPackingResponseDto> getByOrderId(@PathVariable("orderId") Long orderId) {
		return ApiResponse.success(packingFacadeService.getByOrderId(orderId));
	}

	@ApiOperation("패킹 상태 변경 API")
	@PatchMapping("status/{packingId}")
	public ApiResponse<PackingResponseDto> updatePackingStatusDone(
		@PathVariable("packingId") Long packingId,
		@RequestBody UpdatePackingStatusRequestDto dto
	) {
		return ApiResponse.success(packingFacadeService.updatePackingStatus(packingId, dto));
	}
}
