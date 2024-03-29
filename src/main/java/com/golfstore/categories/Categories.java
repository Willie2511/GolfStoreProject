package com.golfstore.categories;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "categories")
public class Categories {
	
	@Id
	private int id;
	
	private String name;
	private String image;
	
	public Categories() {}
	
	public Categories(int id, String name, String image) {
		this.id = id;
		this.name = name;
		this.image = image;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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


	

}
