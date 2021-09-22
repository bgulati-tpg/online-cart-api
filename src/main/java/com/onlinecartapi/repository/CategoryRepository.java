package com.onlinecartapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlinecartapi.domain.ProductCategory;
import com.onlinecartapi.domain.Products;

@Repository
public interface CategoryRepository extends JpaRepository<ProductCategory, Integer>{
	Optional<ProductCategory> findByUuid(String uuid);
}
