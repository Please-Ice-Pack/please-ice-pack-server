package com.kurly.pip.config.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.kurly.pip.common.PipException;
import com.kurly.pip.common.ResultCode;
import com.kurly.pip.config.jwt.JwtService;
import com.kurly.pip.entity.member.Member;
import com.kurly.pip.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PreAuthTokenProvider implements AuthenticationProvider {

    private final MemberService memberService;
    private final JwtService jwtService;

    @Autowired
    Environment environment;

    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        if (authentication instanceof PreAuthenticatedAuthenticationToken) {
            String token = authentication.getPrincipal().toString();
            Long memberId = jwtService.decode(token);
            Member member = memberService.findByIdOrThrow(memberId);
            return new PreAuthenticatedAuthenticationToken(
                member.getId(),
                "",
                Collections.singletonList(new SimpleGrantedAuthority(member.getRole().name()))
            );
        }
        throw new PipException(ResultCode.UNAUTHORIZED);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
    }
}