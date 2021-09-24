package com.onlinecartapi.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlinecartapi.domain.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	Optional<Products> findByUuid(String uuid);
	Page<Products> findAll(Pageable pageable);
	Page<Products> findByCategoryId(Integer category_id,Pageable pageable);
	Long countByCategoryId(Integer category_id);
}
