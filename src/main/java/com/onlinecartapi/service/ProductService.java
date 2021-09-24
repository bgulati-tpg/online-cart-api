package com.onlinecartapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinecartapi.domain.ProductCategory;
import com.onlinecartapi.domain.Products;
import com.onlinecartapi.dto.CategoriesDTO;
import com.onlinecartapi.dto.ProductDetailDTO;
import com.onlinecartapi.dto.ProductsDTO;
import com.onlinecartapi.repository.CategoryRepository;
import com.onlinecartapi.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	ProductRepository product_repo;
	
	@Autowired 
	CategoryRepository categ_repo;
	
	public Integer getNumberOfPages(Float pageSize, String uuid){
		if(uuid.equals("NONE"))
			return (int)Math.ceil(product_repo.count()/pageSize);
		else {
			Optional<ProductCategory> opc = categ_repo.findByUuid(uuid);
			ProductCategory pc = opc.get();
			return (int)Math.ceil(product_repo.countByCategoryId(pc.getId())/pageSize);
		}
	}
	
	public List<ProductsDTO> getAllProducts(Integer pageNum, Integer pageSize){
		List<ProductsDTO> productDTOList = new ArrayList<ProductsDTO>();
		try {
			List<Products> productList = new ArrayList<Products>();
			Pageable paging = new PageRequest(pageNum, pageSize);
			
			Page<Products> pageProducts = product_repo.findAll(paging);
			productList = pageProducts.getContent();
				
			for(Products p : productList) {
				productDTOList.add(new ProductsDTO(p.getName(), p.getRating(), p.getPrice(), p.getUuid()));
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
	    }
		return productDTOList;
	}
	
	public ProductDetailDTO getProductDetails(String uuid){
		Optional<Products> op = product_repo.findByUuid(uuid);
		Products p = op.get();
		return new ProductDetailDTO(p.getName(), p.getDescription(), p.getRating(), p.getPrice(), p.getUuid());
	}
	
	public List<CategoriesDTO> getCategories(){
		List<ProductCategory> pcl = categ_repo.findAll();
		List<CategoriesDTO> categoryDTOList = new ArrayList<CategoriesDTO>(); 
		for(ProductCategory pc : pcl) {
			categoryDTOList.add(new CategoriesDTO(pc.getName(),pc.getUuid(), pc.getUrl()));
		}
		return categoryDTOList;
	}
	
	public List<ProductsDTO> getProductByCategories(String uuid, Integer pageNum, Integer pageSize) {
		List<ProductsDTO> productDTOList = new ArrayList<ProductsDTO>();
		try {
			List<Products> productList = new ArrayList<Products>();
			Pageable paging = new PageRequest(pageNum, pageSize);
			Optional<ProductCategory> opc = categ_repo.findByUuid(uuid);
			ProductCategory pc = opc.get();
			Page<Products> pageProducts = product_repo.findByCategoryId(pc.getId(), paging);
			productList = pageProducts.getContent();
				
			for(Products p : productList) {
				productDTOList.add(new ProductsDTO(p.getName(), p.getRating(), p.getPrice(), p.getUuid()));
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
	    }
		return productDTOList;
	}
	
}
