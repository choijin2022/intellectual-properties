package com.intellectual.auth.controller;

import com.intellectual.auth.dto.Login;
import com.intellectual.auth.dto.SignUp;
import com.intellectual.auth.entity.Member;
import com.intellectual.auth.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/signup")
    public ResponseEntity<SignUp.Response> signUp(@RequestBody SignUp.Request request) {
        Member member = memberService.signUp(request);
        return ResponseEntity.ok(SignUp.Response.from(member));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody Login login) {

        return ResponseEntity.ok(memberService.login(login));
    }
}
