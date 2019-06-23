package com.sapient.reader;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.Transaction.TransactionKey;

public class XMLReader implements TransactionReaderI{

	@Override
	public Map<TransactionKey,List<Transaction>>  transactionReader(File file) {
		// TODO Auto-generated method stub
		return null;
	}

}
