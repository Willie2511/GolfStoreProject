package com.golfstore.customers;

import javax.persistence.*;



@Entity
@Table(name= "Customers")
public class Customers {
	
	@Id
	@Column(name = "customerId")
	private int customerId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "contactNum")
	private String contactNum;
	
	@Column(name = "emailAddress")
	private String emailAddress;
	
	@Column(name = "password")
	private String password;
	
	public Customers() {}
	
	public Customers(int customerId, String firstName, String lastName, String contactNum, String emailAddress, String password) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNum = contactNum;
		this.emailAddress = emailAddress;
		this.password = password;
		
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerId() {
		return customerId;
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

	public String getContactNumber() {
		return contactNum;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNum = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customers{" +
				"customerId=" + customerId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", contactNum='" + contactNum+ '\'' +
				", emailAddress=" + emailAddress +'\''+
				", password=" + password+
				'}';
	}

}
