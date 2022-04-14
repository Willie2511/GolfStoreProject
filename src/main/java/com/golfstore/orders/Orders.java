package com.golfstore.orders;

import javax.persistence.*;

@Entity
@Table(name= "Orders")
public class Orders {


	@Id
	@Column(name= "orderNumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderNumber;


	@Column(name = "productId")
	private int productId;

	@Column(name = "totalPrice")
	private double totalPrice;

	@Column(name = "status")
	private String status;
	
	public Orders() {}
	
	public Orders(Integer orderNumber,int productId, double totalPrice, String status) {
		this.orderNumber = orderNumber;
		this.productId = productId;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
