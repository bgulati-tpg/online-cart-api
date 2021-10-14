package com.onlinecartapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.onlinecartapi.domain.Order;
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
