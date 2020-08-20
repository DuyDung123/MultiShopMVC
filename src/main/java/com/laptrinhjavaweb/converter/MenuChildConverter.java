package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.MenuChildEntity;
import com.laptrinhjavaweb.entity.MenuDadEntity;
import com.laptrinhjavaweb.model.MenuChildModel;
import com.laptrinhjavaweb.model.MenuDadModel;

@Component
public class MenuChildConverter implements IConvert<MenuChildModel, MenuChildEntity> {

	@Override
	public MenuChildEntity toEntity(MenuChildModel model) {
		MenuChildEntity entity = new  MenuChildEntity();
		entity.setName(model.getName());
		entity.setCode(model.getCode());
		return entity;
	}

	@Override
	public MenuChildEntity toEntity(MenuChildModel model, MenuChildEntity entity) {
		entity.setName(model.getName());
		entity.setCode(model.getCode());
		return entity;
	}

	@Override
	public MenuChildModel toModel(MenuChildEntity entity) {
		MenuChildModel childModel = new MenuChildModel();
		childModel.setId(entity.getId());
		childModel.setName(entity.getName());
		childModel.setCode(entity.getCode());
		childModel.setDadId(entity.getMenuDad().getId());
		childModel.setCreatedDate(entity.getCreatedDate());
		childModel.setCreatedBy(entity.getCreatedBy());
		childModel.setModifiedDate(entity.getModifiedDate());
		childModel.setModifiedBy(entity.getModifiedBy());
		return childModel;
	}
	
	public MenuChildModel toModel(MenuChildEntity entity, MenuDadEntity dadEntity) {
		MenuChildModel childModel = new MenuChildModel();
		MenuDadModel dadModel = new MenuDadModel();
		dadModel.setId(dadEntity.getId());
		dadModel.setName(dadEntity.getName());
		childModel.setId(entity.getId());
		childModel.setName(entity.getName());
		childModel.setCode(entity.getCode());
		childModel.setDadId(entity.getMenuDad().getId());
		childModel.setMenuDad(dadModel);
		childModel.setCreatedDate(entity.getCreatedDate());
		childModel.setCreatedBy(entity.getCreatedBy());
		childModel.setModifiedDate(entity.getModifiedDate());
		childModel.setModifiedBy(entity.getModifiedBy());
		return childModel;
	}

}
