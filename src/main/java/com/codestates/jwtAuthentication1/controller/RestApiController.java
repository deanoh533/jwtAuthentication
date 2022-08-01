package com.codestates.jwtAuthentication1.controller;

import com.codestates.jwtAuthentication1.model.Member;
import com.codestates.jwtAuthentication1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/join")
    public  String join(@RequestBody Member member){
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        memberRepository.save(member);
        return "회원 가입 완료";
    }

    @GetMapping("/home")
    public String home(){
        return "<h1> home </h1>";
    }

    @PostMapping("/token")
    public String token() {
        return "<h1>token</h1>";
    }

}
