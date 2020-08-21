package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;


public interface IProductService {
	
	List<ProductModel> findAll();
	ProductModel findOne(Long id);
	ProductModel save(ProductModel productModel);
	void delete(long[] ids);
}