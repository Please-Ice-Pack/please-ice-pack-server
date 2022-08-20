package com.kurly.pip.facade.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.config.jwt.JwtService;
import com.kurly.pip.dto.member.JoinRequestDto;
import com.kurly.pip.dto.member.JoinResponseDto;
import com.kurly.pip.dto.member.LoginRequestDto;
import com.kurly.pip.dto.member.LoginResponseDto;
import com.kurly.pip.entity.member.Member;
import com.kurly.pip.entity.member.Role;
import com.kurly.pip.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberFacadeService {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public JoinResponseDto join(JoinRequestDto dto) {

        memberService.validateIdentification(dto.getIdentification());

        Member member = Member.of(
            dto.getIdentification(),
            passwordEncoder.encode(dto.getPassword()),
            Role.MANAGER
        );

        return JoinResponseDto.of(jwtService.encode(memberService.create(member).getId()));
    }

    public LoginResponseDto login(LoginRequestDto dto) {

        Member member = memberService.findByIdentificationOrThrow(dto.getIdentification());

        if (!passwordEncoder.matches(dto.getPassword(), member.getPassword())) {
            throw new PipException(ResultCode.NOT_FOUND);
        }

        return LoginResponseDto.of(jwtService.encode(memberService.create(member).getId()));
    }

}
