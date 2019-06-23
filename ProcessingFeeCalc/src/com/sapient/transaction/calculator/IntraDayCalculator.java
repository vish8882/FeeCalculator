package com.sapient.transaction.calculator;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.utils.TransacionConstants;

public class IntraDayCalculator implements TransactionFeeCalculatorI {
	
	/**
	 * method used to calculate processing fee for a intraday transaction
	 * @param transaction
	 * @return Transaction
	 */
	@Override
	public Transaction calculate(Transaction transaction) {
		transaction.setProcessingFee(TransacionConstants.PROCESSING_FEE.TEN.getFee());
		return transaction;
	}

}
