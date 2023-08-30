package main;

public class Customer {
	private int customerId;
	private String name;
	private String email;
	private String phoneNumber;
	private int roomNumber;
	private int lengthOfStay;
	private int out;
	
	public Customer(int customerId, String name, int roomNumber, int lengthofStay, String email, String phoneNumber, int out) {
		this.setName(name);
		this.setCustomerId(customerId);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setRoomNumber(roomNumber);
		this.setLengthOfStay(lengthofStay);
		this.setOut(out);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public int getOut() {
		return out;
	}

	public void setOut(int out) {
		this.out = out;
	}

}
