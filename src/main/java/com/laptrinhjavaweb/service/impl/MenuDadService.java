package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.MenuChildConverter;
import com.laptrinhjavaweb.converter.MenuDadConverter;
import com.laptrinhjavaweb.entity.MenuDadEntity;
import com.laptrinhjavaweb.model.MenuDadModel;
import com.laptrinhjavaweb.repository.MenuDadRepository;
import com.laptrinhjavaweb.service.IMenuDadService;
import com.laptrinhjavaweb.utils.CustomUtils;

@Service
public class MenuDadService implements IMenuDadService {

	@Autowired
	MenuDadRepository dadRepository;

	@Autowired
	MenuDadConverter menuDadConverter;
	
	@Autowired
	MenuChildConverter menuChildConverter;

	@Override
	public List<MenuDadModel> findAll() {
		List<MenuDadModel> menuDadModel = new ArrayList<>();
		List<MenuDadEntity> dadEntities = dadRepository.findAll();
		for (MenuDadEntity item : dadEntities) {
			menuDadModel.add(menuDadConverter.toModel(item));
		}
		return menuDadModel;
	}

	@Override
	public MenuDadModel findOne(Long id) {
		MenuDadEntity dadEntity = dadRepository.findOne(id);
		return (MenuDadModel) menuDadConverter.toModel(dadEntity);
	}

	@Override
	public MenuDadModel save(MenuDadModel menuDadModel) {
		MenuDadEntity dadEntity = new MenuDadEntity();
		menuDadModel.setCode(CustomUtils.customCode(menuDadModel.getName()));
		if (menuDadModel.getId() != null) {
			MenuDadEntity lodDadEntity = dadRepository.findOne(menuDadModel.getId());
			dadEntity = menuDadConverter.toEntity(menuDadModel, lodDadEntity);
		} else {
			dadEntity = menuDadConverter.toEntity(menuDadModel);
		}
		dadEntity = dadRepository.save(dadEntity);
		return menuDadConverter.toModel(dadEntity);
	}
	
	@Override
	public void delete(long[] ids) {
		for(long item:ids) {
			dadRepository.delete(item);
		}	
	}
		
}
