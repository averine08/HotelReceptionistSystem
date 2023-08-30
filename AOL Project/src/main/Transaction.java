package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction{
	
	private String formattedDate;
	private int transactionId;
	private int customerId;
	private int roomNumber;
	private int lengthOfStay;
	private String paymentMethod;
	private boolean paid; 
	
	public Transaction(int transactionId, int customerId, int roomNumber, int lengthOfStay, String paymentMethod, boolean paid) {
		
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    LocalDateTime myDateObj = LocalDateTime.now();
	    
	    this.formattedDate = myDateObj.format(myFormatObj);
	    this.setTransactionId(transactionId);
	    this.setCustomerId(customerId);
	    this.setRoomNumber(roomNumber);
	    this.setLengthOfStay(lengthOfStay);
	    this.setPaymentMethod(paymentMethod);
	    this.setPaid(paid);
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getLengthOfStay() {
		return lengthOfStay;
	}


	public void setLengthOfStay(int lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}


	public int getRoomNumber() {
		return roomNumber;
	}


	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}


	public String getFormattedDate() {
		return formattedDate;
	}


	public boolean isPaid() {
		return paid;
	}


	public void setPaid(boolean paid) {
		this.paid = paid;
	}

}
