package com.onlinecartapi.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.onlinecartapi.domain.DeliveryAddress;
import com.onlinecartapi.domain.OrderProduct;
@Service
public class OrderServiceImpl implements OrderServiceI {
	 @PersistenceContext private EntityManager em;
	@Override
	@Transactional
	public void saveOrder(OrderProduct order) {
		em.persist(order);
		
	}

	@Override
	@Transactional
	public void saveAddressInfo(DeliveryAddress deliveryAddress) {
		em.persist(deliveryAddress);
		
	}


}
