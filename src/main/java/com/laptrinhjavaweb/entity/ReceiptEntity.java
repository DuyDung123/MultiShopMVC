package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Duy Dung
 *
 */
@Entity
@Table(name="receipt")
public class ReceiptEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
	private CartEntity cart;
	
	@Column(name = "totalmoney")
	private float totalMoney;
	
	@Column(name = "status")
	private int status;

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
	
	
}
