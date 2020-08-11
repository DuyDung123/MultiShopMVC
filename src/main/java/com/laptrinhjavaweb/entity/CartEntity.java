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

/**
 * @author Duy Dung
 *
 */
@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Productid")
	private ProductEntity Products;
	
	@OneToMany(mappedBy = "cart")
	private List<ReceiptEntity> receipts = new ArrayList<>();
	
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

	public ProductEntity getProducts() {
		return Products;
	}

	public void setProducts(ProductEntity products) {
		Products = products;
	}

	public List<ReceiptEntity> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<ReceiptEntity> receipts) {
		this.receipts = receipts;
	}
	
	
}
