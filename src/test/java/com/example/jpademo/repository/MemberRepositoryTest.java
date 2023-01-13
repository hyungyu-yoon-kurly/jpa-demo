package com.example.jpademo.repository;

import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.dto.OrderDto;
import com.example.jpademo.repository.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void N_plus_1_문제() {
        List<Member> members = memberRepository.findAll();

        // EAGER

        // LAZY
//        for (Member member : members) {
//            member.getOrders().size();
//        }
        print(members);
    }

    @Test
    public void fetchJoin_사용하기() {
        List<Member> members = memberRepository.findAllFetchJoin();
        print(members);
    }

    @Test
    public void entity_graph_사용() {
        List<Member> members = memberRepository.findAllEntityGraph();

        print(members);
    }

    private static void print(List<Member> members) {
        members.stream().forEach(m -> {
            System.out.println(MemberDto.of(m).toString());
            System.out.println(OrderDto.ofList(m.getOrders()));
        });
    }

    @Test
    public void querydsl_fetch_join() {
        List<Member> members = memberRepository.findMembers();
    }
}