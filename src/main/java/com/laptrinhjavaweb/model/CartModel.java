package com.laptrinhjavaweb.model;

public class CartModel extends AbstractModel<CartModel>{

	private Long ProductId;
	private int quantity;
	private float totalMoney;
	
	public Long getProductId() {
		return ProductId;
	}
	
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getTotalMoney() {
		return totalMoney;
	}
	
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
		
}
