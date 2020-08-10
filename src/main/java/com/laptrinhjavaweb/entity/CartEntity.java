package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Duy Dung
 *
 */
@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity {

	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "totalmoney")
	private float totalMoney;

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
