package com.golfstore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import com.golfstore.categories.Categories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoriesTest {
	
	Categories category = new Categories();
	
	@BeforeEach
	void setUp() {
		category.setId(1);
		category.setName("Irons");
		category.setImage("irons.jpg");
	}

	@Test
	void testGetId() {
		assertEquals(1, category.getId());
	}
	
	@Test
	void testGetName() {
		assertEquals("Irons", category.getName());
	}
	
	@Test
	void testGetImage() {
		assertEquals("irons.jpg", category.getImage());
	}

}
