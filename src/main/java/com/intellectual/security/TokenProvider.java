package com.intellectual.security;

import com.intellectual.auth.type.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class TokenProvider {

    private static final String KEY_ROLES = "role";
    private static final String KEY_MEMBER_ID = "memberId";
    private static final long EXPIRED_TIME = 10000 * 60 * 60; // 10 hour
    private final UserDetailsServiceImpl
            userDetailsService; // DB에서 확인한 사용자 정의가 담긴 userDetailsService를 주입

    @Value("${spring.jwt.secret}")
    private String secretKey;

    public String generateToken(String loginId, Long memberId, Role userType) {
        Claims claims = Jwts.claims().setSubject(loginId);
        claims.put(KEY_ROLES, userType);
        claims.put(KEY_MEMBER_ID, memberId);

        Date now = new Date();
        Date expiredDate = new Date(now.getTime() + EXPIRED_TIME);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    @Transactional
    public Authentication getAuthentication(String jwt) {

        UserDetails userDetails = userDetailsService.loadUserByUsername(getUsername(jwt));

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return paresClaims(token).getSubject();
    }

    public boolean validateToken(String token) {
        if (!StringUtils.hasText(token)) {
            return false; // 토큰이 `null`이거나 비어있으면 `false`를 반환
        }
        Claims claims = paresClaims(token);
        return !claims.getExpiration().before(new Date()); // 토큰 만료시간과 현재 시간을 비교, 지났으면 false 반환
    }

    private Claims paresClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }
}
