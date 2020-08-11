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
@Table(name="product")
public class ProductEntity extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "infodetail", columnDefinition = "Text")
	private String infoDetail;
	
	@Column(name = "promotionproduct")
	private int promotionProduct;
	
	@Column(name = "hotproduct")
	private int hotProduct;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "initialprice")
	private float initialPrice;
	
	@Column(name = "currentprice")
	private float currentPrice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "menuchildid")
	private MenuChildEntity menuChild; 
	
	@OneToMany(mappedBy = "product")
	private List<CartEntity> Carts = new ArrayList<CartEntity>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getInfoDetail() {
		return infoDetail;
	}
	
	public void setInfoDetail(String infoDetail) {
		this.infoDetail = infoDetail;
	}
	
	public int getPromotionProduct() {
		return promotionProduct;
	}
	
	public void setPromotionProduct(int promotionProduct) {
		this.promotionProduct = promotionProduct;
	}
	
	public int getHotProduct() {
		return hotProduct;
	}
	
	public void setHotProduct(int hotProduct) {
		this.hotProduct = hotProduct;
	}
	
	public int getActive() {
		return active;
	}
	
	public void setActive(int active) {
		this.active = active;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getInitialPrice() {
		return initialPrice;
	}
	
	public void setInitialPrice(float initialPrice) {
		this.initialPrice = initialPrice;
	}
	
	public float getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public MenuChildEntity getMenuChild() {
		return menuChild;
	}
	
	public void setMenuChild(MenuChildEntity menuChild) {
		this.menuChild = menuChild;
	}

	public List<CartEntity> getCarts() {
		return Carts;
	}

	public void setCarts(List<CartEntity> carts) {
		Carts = carts;
	}
	
	
}
