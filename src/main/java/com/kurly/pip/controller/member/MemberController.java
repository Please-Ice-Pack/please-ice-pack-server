package com.kurly.pip.controller.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.pip.common.ApiResponse;
import com.kurly.pip.dto.member.JoinRequestDto;
import com.kurly.pip.dto.member.JoinResponseDto;
import com.kurly.pip.dto.member.LoginRequestDto;
import com.kurly.pip.dto.member.LoginResponseDto;
import com.kurly.pip.facade.member.MemberFacadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/members")
@RequiredArgsConstructor
@Api(tags = "멤버")
public class MemberController {

	private final MemberFacadeService memberFacadeService;

	@ApiOperation(
		value = "회원가입",
		notes =
			"<h2> Error Code</h2>" +
				"<p>" +
				"ALREADY_EXISTS_IDENTIFICATION" +
				"</p>"
	)
	@PostMapping("/join")
	public ApiResponse<JoinResponseDto> join(@RequestBody JoinRequestDto dto) {
		return ApiResponse.success(memberFacadeService.join(dto));
	}

	@ApiOperation(
		value = "로그인",
		notes =
			"<h2> Error Code</h2>" +
				"<p>" +
				"LOGIN_INFO_NOT_EXISTS" +
				"</p>"
	)
	@PostMapping("/login")
	public ApiResponse<LoginResponseDto> login(@RequestBody LoginRequestDto dto) {
		return ApiResponse.success(memberFacadeService.login(dto));
	}
}
