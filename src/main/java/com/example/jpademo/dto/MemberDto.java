package com.example.jpademo.dto;

import com.example.jpademo.repository.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class MemberDto {

    private Integer id;

    private String name;

    private String email;

    private List<OrderDto> orders;

    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
//                .orders(OrderDto.ofList(member.getOrders()))
                .build();
    }
}
