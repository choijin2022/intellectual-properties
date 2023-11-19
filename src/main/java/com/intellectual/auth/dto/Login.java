package com.intellectual.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Login {
    @NotBlank(message = "아이디를 작성해주세요.")
    private String loginId;

    @NotBlank(message = "비밀번호를 작성해주세요.")
    private String password;
}
