package com.example.jpademo.repository;

import com.example.jpademo.repository.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer>, MemberRepositoryCustom {

    @Query("select distinct m from Member m join fetch m.orders")
    List<Member> findAllFetchJoin();


    @EntityGraph(attributePaths = "orders")
    @Query("select m from Member m")
    List<Member> findAllEntityGraph();
}
