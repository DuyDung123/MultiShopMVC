package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Duy Dung
 *
 */
@Entity
@Table(name="receipt")
public class ReceiptEntity extends BaseEntity {

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
	
	
}
