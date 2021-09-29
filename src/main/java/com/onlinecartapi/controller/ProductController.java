package com.onlinecartapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinecartapi.domain.Products;
import com.onlinecartapi.dto.CategoriesDTO;
import com.onlinecartapi.dto.ProductDetailDTO;
import com.onlinecartapi.dto.ProductsDTO;
import com.onlinecartapi.repository.ProductRepository;
import com.onlinecartapi.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired ProductService service;
	
	@GetMapping(value = "/getAllList/{pageNum}/{pageSize}")
	public List<ProductsDTO> getAllProduct(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {	
		return service.getAllProducts(pageNum, pageSize);
	}
	
	@GetMapping(value = "/getNumberOfPages/{pageSize}/{uuid}")
	public Integer getNumberOfPages(@PathVariable Float pageSize, @PathVariable String uuid) {	
		return service.getNumberOfPages(pageSize, uuid);
	}
	
	@GetMapping(value = "/getProductDetails/{uuid}")
	public ProductDetailDTO getProductDetails(@PathVariable String uuid) {	
		return service.getProductDetails(uuid);
	}
	
	@GetMapping(value = "/getCategories")
	public List<CategoriesDTO> getCategories() {	
		return service.getCategories();
	}
	
	@GetMapping(value = "/getProductByCategories/{uuid}/{pageNum}/{pageSize}")
	public List<ProductsDTO> getProductByCategories(@PathVariable String uuid, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {	
		return service.getProductByCategories(uuid, pageNum, pageSize);
	}
	
	@GetMapping(value = "/getNumberOfPagesBySearch/{pageSize}/{keyword}")
	public Integer getNumberOfPagesBySearch(@PathVariable Float pageSize, @PathVariable String keyword) {	
		return service.getNumberOfPagesBySearch(pageSize, keyword);
	}
	
	@GetMapping(value = "/getProductBySearch/{name}/{pageNum}/{pageSize}")
	public List<ProductsDTO> getProductBySearch(@PathVariable String name, @PathVariable Integer pageNum, @PathVariable Integer pageSize) {	
		return service.getProductBySearch(name, pageNum, pageSize);
	}
	
}
