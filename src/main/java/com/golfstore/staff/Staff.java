package com.golfstore.staff;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Staff")
public class Staff {
	
	@Id
	private int staffId;
	
	private String firstName;
	
	private String lastName;
	
	private String position;
	
	private String emailAddress;
	
	private String password;
	
	public Staff() {}
	
	public Staff(int staffId, String firstName, String lastName, String position, String emailAddress, String password) {
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	
	
	
}
