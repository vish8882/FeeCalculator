package com.sapient.transaction.calculator;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.utils.TransacionConstants;

public class NormalCalculator implements TransactionFeeCalculatorI {
	
	/**
	 * method used to calculate processing fee for a normal transaction
	 * @param transaction
	 * @return Transaction
	 */
	@Override
	public Transaction calculate(Transaction transaction) {
		if(transaction.isPriorityFlag())
			transaction.setProcessingFee(TransacionConstants.PROCESSING_FEE.FIVEHUNDREAD.getFee());
		else {
			if(transaction.getTransactionType().equals(TransacionConstants.transactionType.Sell.toString())
					|| transaction.getTransactionType().equals(TransacionConstants.transactionType.Withdraw.toString())){
				transaction.setProcessingFee(TransacionConstants.PROCESSING_FEE.HUNDREAD.getFee());
			}
			else if(transaction.getTransactionType().equals(TransacionConstants.transactionType.Buy.toString())
					|| transaction.getTransactionType().equals(TransacionConstants.transactionType.Deposit.toString())){
				transaction.setProcessingFee(TransacionConstants.PROCESSING_FEE.FIFTY.getFee());
			}
		}
		return transaction;
	}

}
