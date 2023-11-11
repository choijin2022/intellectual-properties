package com.intellectual.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    NOT_EXIST_MEMBER("존재하지 않는 회원 입니다.", HttpStatus.NOT_FOUND),

    PASSWORD_BE_DIFFERENT("아이디 또는 비밀번호가 잘못되었습니다", HttpStatus.BAD_REQUEST);
    private final String message;
    private final HttpStatus status;

}
