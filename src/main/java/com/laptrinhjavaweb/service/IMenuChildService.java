package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.MenuChildModel;

public interface IMenuChildService {
	List<MenuChildModel> findAll();
	MenuChildModel findOne(Long id);
	MenuChildModel save(MenuChildModel menuChidModel);
	void delete(long[] ids);
}
