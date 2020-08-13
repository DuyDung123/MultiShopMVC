package com.laptrinhjavaweb.model;

public class ReceiptModel extends AbstractModel<ReceiptModel>{

	private Long userId;
	private Long cartId;
	private float totalMoney;
	private int status;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getCartId() {
		return cartId;
	}
	
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	
	public float getTotalMoney() {
		return totalMoney;
	}
	
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
}
