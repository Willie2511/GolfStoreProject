package com.golfstore.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import com.golfstore.staff.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffTest {

	Staff staff = new Staff();
	
	@BeforeEach
	void setUp() {
		staff.setStaffId(1);
		staff.setFirstName("Mary");
		staff.setLastName("May");
		staff.setPosition("Manager");
		staff.setEmailAddress("mm@yahoo.com");
		staff.setPassword("password");
	}
	@Test
	void testGetStaffId() {
		assertEquals(1, staff.getStaffId());
	}
	
	@Test
	void testGetFirstName() {
		assertEquals("Mary", staff.getFirstName());
	}
	
	@Test
	void testGetLastName() {
		assertEquals("May", staff.getLastName());
	}
	
	@Test
	void testGetPosition() {
		assertEquals("Manager", staff.getPosition());
	}
	
	@Test
	void testGetEmailAddress() {
		assertEquals("mm@yahoo.com", staff.getEmailAddress());
	}
	
	@Test
	void testGetPassword() {
		assertEquals("password", staff.getPassword());
	}

}
