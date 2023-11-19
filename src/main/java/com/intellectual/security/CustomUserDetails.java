package com.intellectual.security;

import com.intellectual.auth.entity.Member;
import com.intellectual.auth.type.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {

    public Member member; // Member 엔티티- loginId 및 role 등이 정의되어 있음

    public CustomUserDetails(Member member) {
        super(member.getLoginId(), "", authorities(member.getRole()));
        this.member = member;
    }

    private static Collection<? extends GrantedAuthority> authorities(Role role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
    }
}
