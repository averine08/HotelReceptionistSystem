package Model;

import Data.*;
import java.util.Date;

public class Transaction {
	private int transactionId;
	private int customerId;
	private int roomNumber;
	private Date checkInDate;
	private int lengthOfStay;
	private Date checkOutDate;
	private String paymentMethod;
	private boolean isPaid;
	
	public Transaction(int transactionId, int customerId, int roomNumber, Date checkInDate, int lengthOfStay, Date checkOutDate, String paymentMethod, boolean isPaid) {
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.roomNumber = roomNumber;
		this.checkInDate = checkInDate;
		this.lengthOfStay = lengthOfStay;
		this.checkOutDate = checkOutDate;
		this.paymentMethod = paymentMethod;
		this.isPaid = isPaid;
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
	
	public Customer getCustomer() {
		return new MsCustomer().getCustomerById(customerId);
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Room getRoom() {
		return new MsRoom().getRoomByNumber(roomNumber);
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public int getLengthOfStay() {
		return lengthOfStay;
	}

	public void setLengthOfStay(int lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}
	
	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
}
