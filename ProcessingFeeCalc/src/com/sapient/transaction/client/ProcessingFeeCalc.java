package com.sapient.transaction.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.Transaction.TransactionKey;
import com.sapient.transaction.calculator.TransactionFeeCalculatorI;
import com.sapient.transaction.calculator.TransactionIdentifier;
import com.sapient.transaction.utils.FeeCalculatorUtil;

public class ProcessingFeeCalc implements ProcessingFeeCalcI{
	
	private Map<TransactionKey,List<Transaction>> transactionMap = null;
	private List<Transaction> transactionList = null;
	public ProcessingFeeCalc(Map<TransactionKey,List<Transaction>> transactionMap) {
		this.transactionMap = transactionMap;
	}
	
	/**
	 * method to calculate processing fee for transactions
	 * @return List
	 */
	public List<Transaction> calculateFee() {
		transactionList = new ArrayList<>();
		if(transactionMap == null || transactionMap.isEmpty())
			return transactionList;
		Set<TransactionKey> set = transactionMap.keySet();
		for (TransactionKey transactionKey : set) {
			List<Transaction> list = transactionMap.get(transactionKey);
			//iterate through the list to find if the transaction is intraDay or normal
			while (list.size() > 0) {
				List<Transaction> outputList = new ArrayList<>();
				//utility to identify whether a transaction is intraDay or normal
				TransactionFeeCalculatorI calculator = TransactionIdentifier.identifyTransaction(list.get(0), list,
						outputList);
				//calculate the processing fee for the transaction, list size would be 1 for normal transaction
				//and 2 for intraDay transaction
				for (Transaction trans : outputList)
					transactionList.add(calculator.calculate(trans));
			}
		}
		return transactionList;
	}
	
	/**
	 * API to display the final report
	 */
	public void displayReport() {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		transactionList.sort(Comparator.comparing(Transaction::getClientId)
	            .thenComparing(Transaction::getTransactionType)
	            .thenComparing(Transaction::getTransactionDate)
	            .thenComparing(Transaction::isPriorityFlag));
		for(Transaction transaction: transactionList) {
			System.out.println(transaction.getClientId() +"|"+ transaction.getTransactionType()
			+"|" + transaction.getTransactionDate() +"|"+ FeeCalculatorUtil.getPriorityString(transaction.isPriorityFlag())
			+"|" + transaction.getProcessingFee());
		}
	}
}
