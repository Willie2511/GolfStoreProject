package com.golfstore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import com.golfstore.products.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductsTest {

	Products product = new Products();
	
	
	@BeforeEach
	void setUp() {
		product.setProductId(1);
		product.setCategory("Driver");
		product.setMake("Titleist");
		product.setModel("t3");
		product.setPrice(399.99);
		product.setImage("driver.jpg");
	}
	
	@Test
	void testGetProductId() {
		assertEquals(1, product.getProductId());
	}
	
	@Test
	void testGetCategory() {
		assertEquals("Driver", product.getCategory());
	}
	
	@Test
	void testGetMake() {
		assertEquals("Titleist", product.getMake());
	}
	
	@Test
	void testGetModel() {
		assertEquals("t3", product.getModel());
	}
	
	@Test
	void testGetPrice() {
		assertEquals(399.99, product.getPrice());
	}
	
	@Test
	void testGetImage() {
		assertEquals("driver.jpg", product.getImage());
	}

}
