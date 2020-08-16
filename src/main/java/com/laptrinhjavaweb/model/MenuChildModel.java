package com.laptrinhjavaweb.model;

public class MenuChildModel extends AbstractModel<MenuChildModel> {

	private String name;
	private String code;
	private Long dadId;
	private MenuDadModel menuDad;
	
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
	
	public Long getDadId() {
		return dadId;
	}
	
	public void setDadId(Long dadId) {
		this.dadId = dadId;
	}

	public MenuDadModel getMenuDad() {
		return menuDad;
	}

	public void setMenuDad(MenuDadModel menuDad) {
		this.menuDad = menuDad;
	}
	
	
	
}
