package com.sapient.transaction.calculator;

import com.sapient.transaction.Transaction;

public interface TransactionFeeCalculatorI {
	
	public Transaction calculate(Transaction transaction) ;

}
