package com.sapient.reader;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.Transaction.TransactionKey;

public interface TransactionReaderI {
	
	public Map<TransactionKey,List<Transaction>> transactionReader(File file);

}
