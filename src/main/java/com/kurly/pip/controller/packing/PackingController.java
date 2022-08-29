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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/packings")
@RequiredArgsConstructor
@Api(tags = "패킹")
public class PackingController {

	private final PackingFacadeService packingFacadeService;

	@ApiOperation(value = "패킹 데이터 조회 API",
		notes =
			"orderDetails.coldType: NORMAL(상온) / REFRIGERATED(냉장) / FROZEN(냉동) \n"
				+ "recognitionResults.coldType: NORMAL(상온) / REFRIGERATED(냉장) / FROZEN(냉동) \n"
				+ "boxes.type: NORMAL(일반 박스) / POUCH(종이 파우치) / PURPLE(퍼플 박스) \n"
				+ "refrigerants.type: DRY_ICE(드라이 아이스) / ICE_PACK(아이스팩)"
				+ "<h2> Error Code</h2>"
				+ "<p>"
				+ "NOT_PRE_PROGRESS_STATUS"
				+ "</p>")
	@GetMapping("orders/{orderId}")
	public ApiResponse<GetPackingResponseDto> getByOrderId(@PathVariable("orderId") Long orderId) {
		return ApiResponse.success(packingFacadeService.getByOrderId(orderId));
	}

	@ApiOperation(value = "패킹 상태 변경 API",
		notes =
			"status: PRE_PROGRESS(패킹 진행 전) / IN_PROGRESS(패킹 진행 중) / DONE(패킹 진행 완료), HOLD(패킹 진행 보류)"
				+ "<h2> Error Code</h2>"
				+ "<p>"
				+ "NOT_FOUND"
				+ "</p>")
	@PatchMapping("status/{packingId}")
	public ApiResponse<PackingResponseDto> updatePackingStatusDone(
		@PathVariable("packingId") Long packingId,
		@RequestBody UpdatePackingStatusRequestDto dto
	) {
		return ApiResponse.success(packingFacadeService.updatePackingStatus(packingId, dto));
	}
}
