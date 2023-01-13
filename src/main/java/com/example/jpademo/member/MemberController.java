package com.example.jpademo.member;

import com.example.jpademo.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable Integer id) {
        return memberService.getMember(id);
    }
}
