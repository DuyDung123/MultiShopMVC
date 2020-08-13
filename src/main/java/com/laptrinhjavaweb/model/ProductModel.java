package com.laptrinhjavaweb.model;

public class ProductModel extends AbstractModel<ProductModel>{
 
	private String name;
	private String image;
	private String infoDetail;
	private int promotionProduct;
	private int hotProduct;
	private int active;
	private int quantity;
	private float initialPrice;
	private float currentPrice;
	private Long menuchild;
	
	
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
	
	public Long getMenuchild() {
		return menuchild;
	}
	
	public void setMenuchild(Long menuchild) {
		this.menuchild = menuchild;
	}	
	
}
