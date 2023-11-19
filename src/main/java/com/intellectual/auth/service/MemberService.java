package com.intellectual.auth.service;

import com.intellectual.auth.dto.Login;
import com.intellectual.auth.dto.SignUp.Request;
import com.intellectual.auth.entity.Member;
import com.intellectual.auth.repository.MemberRepository;
import com.intellectual.auth.type.Role;
import com.intellectual.global.exception.CustomException;
import com.intellectual.global.exception.ErrorCode;
import com.intellectual.security.TokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public Member signUp(Request request) {
        if (memberRepository.existsByLoginId(request.getLoginId())) {
            throw new CustomException(ErrorCode.ALREADY_SIGNUP);
        }

        String password = passwordEncoder.encode(request.getPassword());

        return memberRepository.save(
                Member.builder()
                        .loginId(request.getLoginId())
                        .password(password)
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .role(Role.ROLE_MEMBER)
                        .gender(request.getGender())
                        .build());
    }

    @Transactional
    public String login(Login request) {
        Member member =
                memberRepository
                        .findByLoginId(request.getLoginId())
                        .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_MEMBER));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new CustomException(ErrorCode.FAILED_LOGIN);
        }
        return tokenProvider.generateToken(member.getLoginId(), member.getId(), member.getRole());
    }
}
