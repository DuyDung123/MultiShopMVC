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
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IMenuChildService;
import com.laptrinhjavaweb.utils.CustomUtils;

@Service
public class MenuChildService implements IMenuChildService{

	@Autowired
	private MenuChildRepository menuChildRepository;
	
	@Autowired
	private MenuDadRepository menuDadRepository;
	
	@Autowired
	private MenuChildConverter menuChildConverter;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<MenuChildModel> findAll() {
		List<MenuChildModel> childModel = new ArrayList<>();
		List<MenuChildEntity> childEntities = menuChildRepository.findAll();
		for (MenuChildEntity item : childEntities) {
			childModel.add(menuChildConverter.toModel(item));
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
			productRepository.deleteByMenuchild(id);
			menuChildRepository.delete(id);
		}
	}

}
