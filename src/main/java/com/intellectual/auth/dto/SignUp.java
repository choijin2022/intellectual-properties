package com.intellectual.auth.dto;

import com.intellectual.auth.type.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SignUp {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {

        private String loginId;

        private String password;

        private String name;

        private String phoneNumber;

        @Enumerated(EnumType.STRING)
        private Gender gender;
    }
}
