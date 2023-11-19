package com.intellectual.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    VALIDATION_FAILED("validation 오류", HttpStatus.BAD_REQUEST),
    ENUM_VALIDATION("enum class validation 오류", HttpStatus.BAD_REQUEST),
    INTERNAL_SERVER_ERROR("알 수 없는 에러입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    ALREADY_SIGNUP("이미 가입된 회원입니다.", HttpStatus.BAD_REQUEST),
    NOT_EXIST_MEMBER("존재하지 않는 회원 입니다.", HttpStatus.NOT_FOUND),
    FAILED_LOGIN("아이디 또는 비밀번호가 잘못되었습니다", HttpStatus.BAD_REQUEST);
    private final String message;
    private final HttpStatus status;
}
