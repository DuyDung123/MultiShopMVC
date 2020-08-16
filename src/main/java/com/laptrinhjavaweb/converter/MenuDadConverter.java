package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.MenuDadEntity;
import com.laptrinhjavaweb.model.MenuDadModel;

@Component
public class MenuDadConverter implements IConvert<MenuDadModel, MenuDadEntity> {

	@Override
	public MenuDadEntity toEntity(MenuDadModel model) {
		MenuDadEntity entity = new  MenuDadEntity();
		entity.setName(model.getName());
		entity.setCode(model.getCode());
		return entity;
	}

	@Override
	public MenuDadEntity toEntity(MenuDadModel model, MenuDadEntity entity) {
		entity.setName(model.getName());
		entity.setCode(model.getCode());
		return entity;
	}
	
	@Override
	public MenuDadModel toModel(MenuDadEntity entity) {
			MenuDadModel dadModel = new  MenuDadModel();
			if(entity.getId() != null) {
				dadModel.setId(entity.getId());
			}
			dadModel.setName(entity.getName());
			dadModel.setCode(entity.getCode());
			dadModel.setCreatedDate(entity.getCreatedDate());
			dadModel.setCreatedBy(entity.getCreatedBy());
			dadModel.setModifiedDate(entity.getModifiedDate());
			dadModel.setModifiedBy(entity.getModifiedBy());
			dadModel.setMenuChilds(entity.getMenuChilds());
		return dadModel;
	}
	
}
