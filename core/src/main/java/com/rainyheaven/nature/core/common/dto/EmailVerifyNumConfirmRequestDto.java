package com.rainyheaven.nature.core.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailVerifyNumConfirmRequestDto {

    private String email;
    private int verifyNum;

}