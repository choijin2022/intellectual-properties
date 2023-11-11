package com.intellectual.auth.service;

import com.intellectual.auth.dto.Login;
import com.intellectual.auth.entity.Member;
import com.intellectual.auth.repository.MemberRepository;
import com.intellectual.global.exception.CustomException;
import com.intellectual.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public String login(Login request) {
        Member member =
            memberRepository.findByLoginId(request.getLoginId())
                .orElseThrow(()-> new CustomException(ErrorCode.NOT_EXIST_MEMBER));

        if (!member.getPassword().equals(request.getPassword())){
            throw new CustomException(ErrorCode.PASSWORD_BE_DIFFERENT);
        }

        return member.getName();

    }
}
