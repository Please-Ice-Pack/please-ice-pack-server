package com.kurly.pip.dto.member;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestDto {

    @NotNull
    private String identification;

    @NotNull
    private String password;
}
