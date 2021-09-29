package com.onlinecartapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onlinecartapi.domain.Order;
import com.onlinecartapi.domain.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	//@Query("SELECT o from Order o WHERE o.customerId.usrId = :id")
	List<Order> findByCustomerId(User user);

}
