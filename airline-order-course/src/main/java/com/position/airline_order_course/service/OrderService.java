package com.position.airline_order_course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.position.airline_order_course.dto.OrderDto;
import com.position.airline_order_course.mapper.OrderMapper;
import com.position.airline_order_course.model.Order;
import com.position.airline_order_course.repo.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // 查询所有订单
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        // 使用 MapStruct进行转换
        List<OrderDto> orderDtoList = OrderMapper.INSTANCE.toOrderDtoList(orders);
        return orderDtoList;

    }

    // 根据Id查询单个订单
    public OrderDto getOrderById(Long id) {

        Order order = orderRepository.getOrderById(id);
        // 使用 MapStruct进行转换
        OrderDto orderDto = OrderMapper.INSTANCE.ToOrderDto(order);
        return orderDto;

    }

}
