package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menuchild")
public class MenuChildEntity extends BaseEntity{

	@Column(name = "name")
	private String name;
	
	@Column(name = "code")
	private String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuDadid")
	private MenuDadEntity menuDad;
	
	@OneToMany(mappedBy = "menuchild")
	private List<ProductEntity> products = new ArrayList<ProductEntity>();
	
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

	public MenuDadEntity getMenuDad() {
		return menuDad;
	}

	public void setMenuDad(MenuDadEntity menuDad) {
		this.menuDad = menuDad;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
	
}
