package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.MenuChildConverter;
import com.laptrinhjavaweb.entity.MenuChildEntity;
import com.laptrinhjavaweb.entity.MenuDadEntity;
import com.laptrinhjavaweb.model.MenuChildModel;
import com.laptrinhjavaweb.repository.MenuChildRepository;
import com.laptrinhjavaweb.repository.MenuDadRepository;
import com.laptrinhjavaweb.service.IMenuChildService;
import com.laptrinhjavaweb.utils.CustomUtils;

@Service
public class MenuChildService implements IMenuChildService{

	@Autowired
	MenuChildRepository menuChildRepository;
	
	@Autowired
	MenuDadRepository menuDadRepository;
	
	@Autowired
	MenuChildConverter menuChildConverter;

	@Override
	public List<MenuChildModel> findAll() {
		List<MenuChildModel> childModel = new ArrayList<>();
		List<MenuChildEntity> childEntities = menuChildRepository.findAll();
		for (MenuChildEntity item : childEntities) {
			MenuDadEntity dadEntity = menuDadRepository.findOne(item.getMenuDad().getId());
			childModel.add(menuChildConverter.toModel(item, dadEntity));
		}
		return childModel;
	}

	@Override
	public MenuChildModel findOne(Long id) {
		MenuChildEntity childEntities = menuChildRepository.findOne(id);
		return (MenuChildModel) menuChildConverter.toModel(childEntities);
	}

	@Override
	public MenuChildModel save(MenuChildModel menuChildModel) {
		MenuChildEntity childEntities = new MenuChildEntity();
		menuChildModel.setCode(CustomUtils.customCode(menuChildModel.getName()));
		if (menuChildModel.getId() != null) {
			MenuChildEntity lodChildEntity = menuChildRepository.findOne(menuChildModel.getId());
			childEntities = menuChildConverter.toEntity(menuChildModel, lodChildEntity);
		} else {
			childEntities = menuChildConverter.toEntity(menuChildModel);
		}
		MenuDadEntity dadEntity = menuDadRepository.findOne(menuChildModel.getDadId());
		childEntities.setMenuDad(dadEntity);
		childEntities = menuChildRepository.save(childEntities);
		return menuChildConverter.toModel(childEntities);
	}

	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			menuChildRepository.delete(id);
		}
	}

}
