package Data;

import java.util.ArrayList;

import Model.Customer;

public class MsCustomer {
	
	private static ArrayList<Customer> msCustomer = new ArrayList<>();
	
	public MsCustomer() {
		
	}
	
	public void generateDummyData() {
		msCustomer.add(new Customer(1, "Averina", "averina@gmail.com", "081111111111"));
		msCustomer.add(new Customer(2, "Gabriel", "gabriel@gmail.com", "082222222222"));
		msCustomer.add(new Customer(3, "Gavriel", "gavriel@gmail.com", "083333333333"));
		msCustomer.add(new Customer(4, "Karen", "karen@gmail.com", "0844444444444"));
		msCustomer.add(new Customer(5, "Roland", "roland@gmail.com", "0855555555555"));
	}
	
	public ArrayList<Customer> getAllCustomerList() {
		return msCustomer;
	}
	
	public Customer getCustomerById(int customerId) {
		return msCustomer.stream().filter(customer -> customer.getCustomerId() == customerId).findFirst().get();
	}
	
	public int addNewCustomer(String name, String email, String phoneNumber) {
		int lastCustomerId = msCustomer.get(msCustomer.size() - 1).getCustomerId();
		Customer newCustomer = new Customer(lastCustomerId + 1, name, email, phoneNumber);
		
		msCustomer.add(newCustomer);
		
		return lastCustomerId + 1;
	}
}
