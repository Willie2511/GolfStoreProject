package com.golfstore.products;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Products")
public class Products {

	@Id
	private int productId;
	
	private String category;
	
	private String make;
	
	private String model;
	
	private Double price;
	
	private String image;
	
	public Products() {}
	
	public Products(int productId, String category, String make, String model, Double price, String image) {
		this.productId = productId;
		this.category = category;
		this.make = make;
		this.model = model;
		this.price = price;
		this.image = image;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
