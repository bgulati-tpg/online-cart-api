package com.onlinecartapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinecartapi.domain.Order;
import com.onlinecartapi.domain.User;
import com.onlinecartapi.dto.OrderHistoryDto;
import com.onlinecartapi.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<OrderHistoryDto> getOrderListByUserId(Long userId) {
		List<Order> orderList = orderRepository.findByCustomerId(new User(userId));
		List<OrderHistoryDto> orderHistoryDtoList = new ArrayList<>();
		return populateOrderHistoryDto(orderHistoryDtoList, orderList);

	}

	private List<OrderHistoryDto> populateOrderHistoryDto(List<OrderHistoryDto> orderHistoryDtoList,
			List<Order> orderList) {
		for (Order order : orderList) {
			orderHistoryDtoList.add(new OrderHistoryDto(order.getOrderId(), order.getProductName(),
					order.getCustomerId().getUserId(), order.getTotalAmount()));
		}
		return orderHistoryDtoList;
	}
}
