package com.golfstore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import com.golfstore.orders.Orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrdersTests {

	Orders orders = new Orders();
	
	@BeforeEach
	void setUp() {
		orders.setProductId(1);
		orders.setTotalPrice(1.99);
		orders.setStatus("complete");
	}

	
	@Test
	void testProductId() {
		assertEquals(1, orders.getProductId());
	}
	
	@Test
	void testTotalPrice() {
		assertEquals(1.99, orders.getTotalPrice());
	}
	
	@Test
	void testStatus() {
		assertEquals("complete", orders.getStatus());
	}

}
