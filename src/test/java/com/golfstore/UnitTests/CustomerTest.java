package com.golfstore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;


import com.golfstore.customers.Customers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	Customers customer = new Customers();
	
	@BeforeEach
	void setUp() {
		customer.setCustomerId(1);
		customer.setFirstName("Joe");
		customer.setLastName("Bloggs");
		customer.setContactNumber("0871234567");
		customer.setEmailAddress("jBloggs@yahoo.com");
		customer.setPassword("1234");
	}
	
	@Test
	void testGetCustomerId() {
		int expected = 1;
		int actual = customer.getCustomerId();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetFirstName() {
		String expected = "Joe";
		String actual = customer.getFirstName();
		assertEquals(expected, actual);	
	}
	
	@Test
	void testGetLastName() {
		assertEquals("Bloggs", customer.getLastName());
	}
	
	@Test
	void testGetContactNum() {
		assertEquals("0871234567", customer.getContactNumber());
	}
	
	@Test
	void testGetEmailAddress() {
		assertEquals("jBloggs@yahoo.com", customer.getEmailAddress());
	}
	
	@Test
	void testGetPassword() {
		assertEquals("1234", customer.getPassword());
	}

}
