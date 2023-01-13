package com.example.jpademo.repository;

import com.example.jpademo.repository.entity.Member;
import com.example.jpademo.repository.entity.QMember;
import com.example.jpademo.repository.entity.QOrder;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.example.jpademo.repository.entity.QMember.member;
import static com.example.jpademo.repository.entity.QOrder.order;

public class MemberRepositoryCustomImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom {

    public MemberRepositoryCustomImpl() {
        super(Member.class);
    }

    @Override
    public List<Member> findMembers() {
        return from(member)
                .join(member.orders, order)
//                .join(member.orders, order).fetchJoin()
                .fetch();
    }
}
