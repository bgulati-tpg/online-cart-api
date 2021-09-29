package com.onlinecartapi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinecartapi.domain.User;
import com.onlinecartapi.dto.OrderHistoryDto;
import com.onlinecartapi.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired OrderService service;

	@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:4200"})
	@GetMapping(value = "/getOrders")
	public List<OrderHistoryDto> getProductDetails() {	
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return service.getOrderListByUserId(user.getUserId());
	}
}
