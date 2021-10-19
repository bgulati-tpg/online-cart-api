package com.onlinecartapi.service;

import org.springframework.stereotype.Service;

import com.onlinecartapi.domain.DeliveryAddress;
import com.onlinecartapi.domain.OrderProduct;
@Service
public interface OrderServiceI {
	public void saveOrder(OrderProduct order);
	public void saveAddressInfo(DeliveryAddress deliveryAddress);

}
