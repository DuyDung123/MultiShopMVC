package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menudad")
public class MenuDadEntity extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "menudad")
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
