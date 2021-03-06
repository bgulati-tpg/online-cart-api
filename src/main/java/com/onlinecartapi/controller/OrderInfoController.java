package com.onlinecartapi.controller;

import java.util.Date;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinecartapi.domain.DeliveryAddress;
import com.onlinecartapi.domain.OrderProduct;
import com.onlinecartapi.domain.User;
import com.onlinecartapi.dto.OrderInfoDto;
import com.onlinecartapi.service.OrderServiceI;
import com.onlinecartapi.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderInfoController {
	@Autowired
	UserService userService;
	@Autowired
	OrderServiceI service;

	@CrossOrigin(origins = { "http://localhost:4200", "http://127.0.0.1:4200" })
	@PostMapping(value = "/")
	public ResponseEntity<?> placeOrder(@Valid @RequestBody OrderInfoDto orderDto) {
		OrderProduct order = new OrderProduct();
		StringBuffer sb = new StringBuffer();
		Double double1 = new Double(0);
		for (int i = 0; i < orderDto.getOrderedProduct().size(); i++) {
			sb.append(orderDto.getOrderedProduct().get(i).getName());
			sb.append(",");
			double1 = double1 + orderDto.getOrderedProduct().get(i).getPrice();
		}
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = "";
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		Optional<User> user = userService.getUserByEmail(username);
		if (user.isPresent())
			order.setCustomerId(user.get());
		order.setProduct_name(sb.toString().substring(0, sb.length() -1));
		order.setTotalAmount(double1.doubleValue());
		order.setDate(new Date());
		DeliveryAddress address = new DeliveryAddress();
		address.setCustomerName(orderDto.getFuullName());
		address.setPhone(orderDto.getPhone());
		address.setAddress1(orderDto.getAddress1());
		address.setAddress2(orderDto.getAddress2());
		address.setCity(orderDto.getCity());
		address.setState(orderDto.getState());
		address.setPincode(orderDto.getPincode());
		address.setOrderId(order);
		service.saveAddressInfo(address);
		return null;
	}

}
