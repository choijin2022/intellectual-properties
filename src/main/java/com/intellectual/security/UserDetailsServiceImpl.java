package com.intellectual.security;

import com.intellectual.auth.entity.Member;
import com.intellectual.auth.repository.MemberRepository;
import com.intellectual.global.exception.CustomException;
import com.intellectual.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository memberRepository; // 사용자 정보를 DB에서 가져와야 하므로 Repository 주입.

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member member =
                memberRepository
                        .findByLoginId(loginId)
                        .orElseThrow(() -> new CustomException(ErrorCode.NOT_EXIST_MEMBER));
        return new CustomUserDetails(
                member); // 사용자 정의가 담긴 member를 매개변수로 받은 CustomUserDetails을 리턴하여 사용자가 존재하지 않으면 예외를 던짐.
    }
}
