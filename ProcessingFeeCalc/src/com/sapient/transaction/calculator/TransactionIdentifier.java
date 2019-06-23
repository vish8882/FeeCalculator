package com.sapient.transaction.calculator;

import java.util.List;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.utils.TransacionConstants;

public class TransactionIdentifier {
	/**
	 * Method finds out if a transaction is normal transaction or intraDay transaction and returns the respective
	 * calculator for them. It also identifies the counterpart transaction if the original transaction is an intraDay.
	 * 
	 * @param transaction Transaction that needs to be identified
	 * @param inputList   list of transaction among which the original transaction has to be checked
	 * @param outpuList	  list of transaction for which fee has to be calculated. 
	 * @return TransactionFeeCalculatorI 
	 */
	public static TransactionFeeCalculatorI identifyTransaction(Transaction transaction, List<Transaction> inputList,
			List<Transaction> outpuList) {
		//if the size is 1 then the transaction is normal transaction
		if (inputList.size() == 1) {
			inputList.remove(0);
			outpuList.add(transaction);
			return new NormalCalculator();
		} else {
			Transaction oppositeTransaction = null;
			boolean isIntraDay = false;
			// iterate to find if the transaction type are opposite or not
			for (Transaction t : inputList) {
				if ((t.getTransactionType().equals(TransacionConstants.transactionType.Buy.toString())
						&& transaction.getTransactionType().equals(TransacionConstants.transactionType.Sell.toString()))
						|| (t.getTransactionType().equals(TransacionConstants.transactionType.Sell.toString())
								&& transaction.getTransactionType()
										.equals(TransacionConstants.transactionType.Buy.toString()))) {
					oppositeTransaction = t;
					isIntraDay = true;
					break;
				}
			}
			if (isIntraDay) {
				inputList.remove(oppositeTransaction);
				inputList.remove(transaction);
				outpuList.add(oppositeTransaction);
				outpuList.add(transaction);
				return new IntraDayCalculator();
			}
			inputList.remove(transaction);
			outpuList.add(transaction);
			return new NormalCalculator();
		}
	}

}
