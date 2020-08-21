package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.model.ProductModel;

@Component
public class ProductConverter implements IConvert<ProductModel, ProductEntity>{

	@Override
	public ProductEntity toEntity(ProductModel model) {
		ProductEntity entity = new ProductEntity();
		entity.setName(model.getName());
		entity.setInfoDetail(model.getInfoDetail());
		entity.setPromotionProduct(model.getPromotionProduct());
		entity.setHotProduct(model.getHotProduct());
		entity.setActive(model.getActive());
		entity.setQuantity(model.getQuantity());
		entity.setInitialPrice(model.getInitialPrice());
		entity.setCurrentPrice(model.getCurrentPrice());
		return entity;
	}

	@Override
	public ProductEntity toEntity(ProductModel model, ProductEntity entity) {
		entity.setName(model.getName());
		entity.setInfoDetail(model.getInfoDetail());
		entity.setPromotionProduct(model.getPromotionProduct());
		entity.setHotProduct(model.getHotProduct());
		entity.setActive(model.getActive());
		entity.setQuantity(model.getQuantity());
		entity.setInitialPrice(model.getInitialPrice());
		entity.setCurrentPrice(model.getCurrentPrice());
		return entity;
	}

	@Override
	public ProductModel toModel(ProductEntity entity) {
		ProductModel model = new ProductModel();
		if(entity.getId() != null) {
			model.setId(entity.getId());
		}
		model.setName(entity.getName());
		model.setInfoDetail(entity.getInfoDetail());
		model.setPromotionProduct(entity.getPromotionProduct());
		model.setHotProduct(entity.getHotProduct());
		model.setActive(entity.getActive());
		model.setQuantity(entity.getQuantity());
		model.setInitialPrice(entity.getInitialPrice());
		model.setCurrentPrice(entity.getCurrentPrice());
		return model;
	}

}
