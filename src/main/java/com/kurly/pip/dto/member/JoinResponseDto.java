package com.kurly.pip.dto.member;

import lombok.Value;

@Value(staticConstructor = "of")
public class JoinResponseDto {

    String accessToken;
}
