package Data;

import java.util.*;
import Model.Transaction;

public class MsTransaction {
	private static ArrayList<Transaction> msTransaction = new ArrayList<>();
	
	public MsTransaction() {
		
	}
	
	public void generateDummyData() {
		Calendar calendarNow = Calendar.getInstance();
		Date dateNow = calendarNow.getTime();
		
		Calendar calendarData1 = Calendar.getInstance();
		calendarData1.add(Calendar.DAY_OF_MONTH, -3);
		
		Calendar calendarData2 = Calendar.getInstance();
		calendarData2.add(Calendar.DAY_OF_MONTH, -2);
		
		Calendar calendarData3 = Calendar.getInstance();
		calendarData3.add(Calendar.DAY_OF_MONTH, -1);
		
		msTransaction.add(new Transaction(1, 1, 101, calendarData1.getTime(), 3, null, "", false));
		msTransaction.add(new Transaction(2, 2, 104, calendarData2.getTime(), 2, null, "", false));
		msTransaction.add(new Transaction(3, 3, 105, calendarData3.getTime(), 1, null, "", false));
		msTransaction.add(new Transaction(4, 4, 204, dateNow, 2, null, "", false));
		msTransaction.add(new Transaction(5, 5, 301, dateNow, 5, null, "", false));
	}
	
	public ArrayList<Transaction> getAllTransactionList() {
		return msTransaction;
	}
	
	public Transaction getTransactionById(int transactionId) {
		return msTransaction.stream().filter(transaction -> transaction.getTransactionId() == transactionId).findFirst().get();
	}
	
	public void addNewTransaction(int customerId, int roomNumber, int lengthOfStay) {
		Calendar calendar = Calendar.getInstance();
		Date dateNow = calendar.getTime();
		
		int lastTransactionId = msTransaction.get(msTransaction.size() - 1).getTransactionId();
		Transaction newTransaction = new Transaction(lastTransactionId + 1, customerId, roomNumber, dateNow, lengthOfStay, null, "", false);
		
		msTransaction.add(newTransaction);
	}
	
	public void payTransaction(Transaction transactionToPay, String paymentMethod) {
		Calendar calendar = Calendar.getInstance();
		Date dateNow = calendar.getTime();
		
		Transaction updateTransaction = msTransaction.get(msTransaction.indexOf(transactionToPay));
		updateTransaction.setPaymentMethod(paymentMethod);
		updateTransaction.setCheckOutDate(dateNow);
		updateTransaction.setPaid(true);
	}
}
