package com.intellectual.auth.dto;

import com.intellectual.auth.entity.Member;
import com.intellectual.auth.type.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SignUp {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotBlank(message = "아이디를 작성해주세요.")
        private String loginId;

        @NotBlank(message = "비밀번호를 작성해주세요.")
        private String password;

        @NotBlank(message = "이름을 작성해주세요.")
        private String name;

        @NotBlank(message = "전화번호를 작성해주세요.")
        private String phoneNumber;

        @NotNull(message = "성별을 선택해주세요")
        @Enumerated(EnumType.STRING)
        private Gender gender;
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

            private long id;
            private String loginId;
            private String name;
            private String phoneNumber;
            private Gender gender;


            public static SignUp.Response from(Member member) {
                return Response.builder()
                    .id(member.getId())
                    .loginId(member.getLoginId())
                    .name(member.getName())
                    .phoneNumber(member.getPhoneNumber())
                    .gender(member.getGender())
                    .build();
            }
        }
}
