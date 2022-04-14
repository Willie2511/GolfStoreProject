package com.golfstore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import com.golfstore.payments.PaymentDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentsTest {
	
	PaymentDetails payments = new PaymentDetails();

	@BeforeEach
	void setUp() {
		payments.setPaymentId(1);
		payments.setCardNum("1234567891234567");
		payments.setCustomerId(1);
		payments.setCvc(123);
		payments.setExpiry("12/24");
		payments.setNameOnCard("Test");
	}

	@Test
	void testPaymentId() {
		assertEquals(1, payments.getPaymentId());
	}

	@Test
	void testCardNum() {
		assertEquals("1234567891234567", payments.getCardNum());
	}
	
	@Test
	void testCustomerId() {
		assertEquals(1, payments.getCustomerId());
	}
	
	@Test
	void testCvc() {
		assertEquals(123, payments.getCvc());
	}
	
	@Test
	void testExpiry() {
		assertEquals("12/24", payments.getExpiry());
	}
	
	@Test
	void testName() {
		assertEquals("Test", payments.getNameOnCard());
	}
}
