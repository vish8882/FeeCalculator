package com.sapient.transaction.client;

import java.util.List;

import com.sapient.transaction.Transaction;

public interface ProcessingFeeCalcI {
	public List<Transaction> calculateFee();
	public void displayReport();
}
