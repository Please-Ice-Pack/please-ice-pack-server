package com.kurly.pip.dto.member;

import lombok.Value;

@Value(staticConstructor = "of")
public class LoginResponseDto {

    String accessToken;
}