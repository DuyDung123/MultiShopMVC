package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.MenuDadModel;

public interface IMenuDadService {

	List<MenuDadModel> findAll();
	MenuDadModel findOne(Long id);
	MenuDadModel save(MenuDadModel menuDadModel);
}
