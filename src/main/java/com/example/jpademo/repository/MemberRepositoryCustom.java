package com.example.jpademo.repository;

import com.example.jpademo.repository.entity.Member;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public interface MemberRepositoryCustom {

    List<Member> findMembers();
}
