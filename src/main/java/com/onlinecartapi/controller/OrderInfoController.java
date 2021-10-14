package com.onlinecartapi.controller;
import java.util.Date;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinecartapi.domain.DeliveryAddress;
import com.onlinecartapi.domain.Order;
import com.onlinecartapi.dto.OrderInfoDto;
import com.onlinecartapi.service.OrderService;
import com.onlinecartapi.service.ProductService;

@RestController
@RequestMapping("/orders")
public class OrderInfoController {
	
	@Autowired OrderService service;

	@PostMapping(value = "/")
	public ResponseEntity<?> placeOrder(@Valid @RequestBody OrderInfoDto orderDto) {
		Order order=new Order();
		StringBuffer sb=new StringBuffer();
		Double double1 = new Double(0);
		for(int i=0;i<orderDto.getOrderedProduct().size();i++) {
		   sb.append(orderDto.getOrderedProduct().get(i).getName());
		   sb.append(",");
		   double1=double1+orderDto.getOrderedProduct().get(i).getPrice();
		}
		order.setProduct_name(sb.toString());
		order.setTotalAmount(double1.doubleValue());
		order.setDate(new Date());
		DeliveryAddress address=new DeliveryAddress();
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
