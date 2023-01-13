package com.example.jpademo.member;

import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.repository.MemberRepository;
import com.example.jpademo.repository.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDto getMember(Integer id) {
        Member member = memberRepository.findById(id).orElse(new Member());
        return MemberDto.of(member);
    }
}
