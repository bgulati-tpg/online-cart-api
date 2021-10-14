package com.onlinecartapi.service;

import org.springframework.stereotype.Service;

import com.onlinecartapi.domain.DeliveryAddress;
import com.onlinecartapi.domain.Order;
@Service
public interface OrderService {
	public void saveOrder(Order order);
	public void saveAddressInfo(DeliveryAddress deliveryAddress);

}
