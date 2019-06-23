package com.sapient.feecalculator.main;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.sapient.reader.TransactionReaderFactory;
import com.sapient.reader.TransactionReaderI;
import com.sapient.transaction.Transaction;
import com.sapient.transaction.Transaction.TransactionKey;
import com.sapient.transaction.client.ProcessingFeeCalc;
import com.sapient.transaction.client.ProcessingFeeCalcI;

public class FeeCalculatorMain {

	public static void main(String[] args) {
		File file= new File("C://Users//1022176//Desktop//Fee.csv");
		TransactionReaderI reader = TransactionReaderFactory.getTransactionReaderInstance("CSV");
		Map<TransactionKey,List<Transaction>> transactionMap = reader.transactionReader(file);
		ProcessingFeeCalcI feeCalc = new ProcessingFeeCalc(transactionMap);
		feeCalc.calculateFee();
		feeCalc.displayReport();
	}
}
