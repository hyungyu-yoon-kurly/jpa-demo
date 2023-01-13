package com.example.jpademo.dto;

import com.example.jpademo.repository.entity.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Builder
public class OrderDto {

    private Integer id;

    private String item;

    public static List<OrderDto> ofList(List<Order> orders) {
        List<OrderDto> dtos = new ArrayList<>();

        for (Order order : orders) {
            dtos.add(OrderDto.builder().id(order.getId()).item(order.getItem()).build());
        }
        return dtos;
    }
}
