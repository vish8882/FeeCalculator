package com.sapient.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.transaction.Transaction;
import com.sapient.transaction.Transaction.TransactionKey;

public class CSVReader extends AbstractTransactionReader implements TransactionReaderI {

	/**
	 * This method takes the input file and returns a Map that is arranged on basis od clientId, securityId and
	 * transactionDate so that intraDay transactions could be segregated easily.
	 * @param file
	 * @return Map<TransactionKey,List<Transaction>> map of transactions segregated by transactionKey
	 */
	@Override
	public Map<TransactionKey,List<Transaction>>  transactionReader(File file){
		Map<TransactionKey,List<Transaction>> transactionMap = new HashMap<>();
		BufferedReader br = null;
		String line = null;
		try {

			br = new BufferedReader(new FileReader(file));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] transactionAttr = line.split(",");
				//creating transactions using transaction attributes from csv file
				Transaction transaction = createTransaction(transactionAttr);
				addTransactionToMap(transaction, transactionMap);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return transactionMap;
	}
}
