package com.golfstore.payments;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "PaymentDetails")
public class PaymentDetails {
	
	@Id
	private int customerId;
	


	private int paymentId;
	
	private String nameOnCard;
	
	private String cardNum;
	
	private String expiry;
	
	private int cvc;

	public PaymentDetails() {}
	
	public PaymentDetails(int customerId, int paymentId, String nameOnCard, String cardNum, String expiry, int cvc) {
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.nameOnCard = nameOnCard;
		this.cardNum = cardNum;
		this.expiry = expiry;
		this.cvc = cvc;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
}
