package com.sapient.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.Transaction.TransactionKey;
import com.sapient.transaction.utils.FeeCalculatorUtil;

public abstract class AbstractTransactionReader implements TransactionReaderI{
	/**
	 * method takes transaction attributes from the file and creates a transaction object from it
	 * @param transactionAttr
	 * @return
	 */
	protected Transaction createTransaction(String[] transactionAttr) {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(transactionAttr[0]);
		transaction.setClientId(transactionAttr[1]);
		transaction.setSecurityId(transactionAttr[2]);
		transaction.setTransactionType(transactionAttr[3]);
		transaction.setTransactionDate(transactionAttr[4]);
		transaction.setMarketValue(Double.valueOf((transactionAttr[5])));
		transaction.setPriorityFlag(FeeCalculatorUtil.getPriority(transactionAttr[6]));
		return transaction;
	}
	
	/**
	 * adds the transaction to transactionMap on basis of clientId, securityId and transactionDate
	 * @param transaction
	 * @param transactionMap
	 */
	protected void addTransactionToMap(Transaction transaction, Map<TransactionKey,List<Transaction>> transactionMap) {
		TransactionKey transactionKey = new TransactionKey(transaction);
		List<Transaction> list = transactionMap.get(transactionKey);
		if(list == null)
			list = new ArrayList<>();
		list.add(transaction);
		transactionMap.put(transactionKey, list);
	}

}
