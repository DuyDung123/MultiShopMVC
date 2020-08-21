package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	ProductRepository ProducRepository;
	
	@Autowired
	ProductConverter productConverter;
	
	@Override
	public List<ProductModel> findAll() {
		List<ProductModel> productModels = new ArrayList<>();
		List<ProductEntity> productEntities = ProducRepository.findAll();
		for(ProductEntity item : productEntities) {
			productModels.add(productConverter.toModel(item));
		}
		return productModels;
	}

	@Override
	public ProductModel findOne(Long id) {
		return productConverter.toModel(ProducRepository.findOne(id));
	}

	@Override
	public ProductModel save(ProductModel productModel) {
		ProductEntity productEntity = new ProductEntity();
		if(productModel.getId() != null) {
			productEntity = ProducRepository.findOne(productModel.getId());
			productEntity = productConverter.toEntity(productModel, productEntity);
		}else {
			productEntity = productConverter.toEntity(productModel);
		}
		productEntity = ProducRepository.save(productEntity);
		return productConverter.toModel(productEntity);
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			ProducRepository.delete(id);
		}
	}

}
