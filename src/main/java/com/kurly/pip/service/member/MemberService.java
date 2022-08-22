package com.kurly.pip.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.entity.member.Member;
import com.kurly.pip.repository.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberRepository memberRepository;

	public Member findByIdOrThrow(Long id) {

		return memberRepository.findById(id)
			.orElseThrow(() -> new PipException(ResultCode.NOT_FOUND));
	}

	public Member findByIdentificationOrThrow(String identification) {

		return memberRepository.findByIdentification(identification)
			.orElseThrow(() -> new PipException(ResultCode.LOGIN_INFO_NOT_EXISTS));
	}

	public void validateIdentification(String identification) {

		if (memberRepository.existsByIdentification(identification)) {
			throw new PipException(ResultCode.ALREADY_EXISTS_IDENTIFICATION);
		}
	}

	@Transactional
	public Member create(Member member) {

		return memberRepository.save(member);
	}
}
