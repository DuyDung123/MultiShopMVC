package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.entity.MenuChildEntity;

public class MenuDadModel extends AbstractModel<MenuDadModel> {
	
	private String name;
	private String code;
	
	private List<MenuChildEntity> menuChilds = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public List<MenuChildEntity> getMenuChilds() {
		return menuChilds;
	}

	public void setMenuChilds(List<MenuChildEntity> menuChilds) {
		this.menuChilds = menuChilds;
	}
	
	
}
